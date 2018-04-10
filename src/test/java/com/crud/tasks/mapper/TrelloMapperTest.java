package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    private TrelloCard createTestTrelloCard() {
        return new TrelloCard("test", "test desc", "test pos", "testId");

    }

    private List<TrelloList> createTestTrelloList() {
        TrelloList trelloList = new TrelloList("test id", "test name", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        return new ArrayList<>(trelloLists);
    }

    @Test
    public void testMapToCardAndCardDto() {
        //Given
        TrelloCard trelloCard = createTestTrelloCard();
        //When
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(mappedTrelloCardDto);
        //Then
        Assert.assertTrue(trelloCard.getName().equals(mappedTrelloCardDto.getName()));
        Assert.assertTrue(trelloCard.getName().equals(mappedTrelloCard.getName()));
        Assert.assertTrue(trelloCard.getDescription().equals(mappedTrelloCard.getDescription()));
        Assert.assertTrue(trelloCard.getDescription().equals(mappedTrelloCardDto.getDescription()));
        Assert.assertTrue(trelloCard.getListId().equals(mappedTrelloCard.getListId()));
        Assert.assertTrue(trelloCard.getListId().equals(mappedTrelloCardDto.getListId()));
        Assert.assertTrue(trelloCard.getPos().equals(mappedTrelloCard.getPos()));
        Assert.assertTrue(trelloCard.getPos().equals(mappedTrelloCardDto.getPos()));
    }

    @Test
    public void testMapToListAndListDto() {
        //Given
        List<TrelloList> trelloLists = createTestTrelloList();
        //When
        List<TrelloListDto> mappedTrelloListsDto = trelloMapper.mapToListDto(trelloLists);
        List<TrelloList> mappedTrelloLists = trelloMapper.mapToList(mappedTrelloListsDto);
        //Then
        Assert.assertTrue(trelloLists.get(0).getId().equals(mappedTrelloListsDto.get(0).getId()));
        Assert.assertTrue(trelloLists.get(0).getId().equals(mappedTrelloLists.get(0).getId()));
        Assert.assertTrue(trelloLists.get(0).getName().equals(mappedTrelloLists.get(0).getName()));
        Assert.assertTrue(trelloLists.get(0).getName().equals(mappedTrelloListsDto.get(0).getName()));
        Assert.assertTrue(trelloLists.get(0).isClosed() == mappedTrelloLists.get(0).isClosed());
        Assert.assertTrue(trelloLists.get(0).isClosed() == mappedTrelloListsDto.get(0).isClosed());
    }

    @Test
    public void testMapToBoardsAndBoardsDto() {
        //Given
        List<TrelloList> trelloLists = createTestTrelloList();
        TrelloBoard trelloBoard = new TrelloBoard("test board id", "test board name", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        //When
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoards);
        List<TrelloBoard> mappedTrelloBoard = trelloMapper.mapToBoards(mappedTrelloBoardDto);
        //Then
        Assert.assertTrue(trelloBoard.getId().equals(mappedTrelloBoard.get(0).getId()));
        Assert.assertTrue(trelloBoard.getId().equals(mappedTrelloBoardDto.get(0).getId()));
        Assert.assertTrue(trelloBoard.getName().equals(mappedTrelloBoard.get(0).getName()));
        Assert.assertTrue(trelloBoard.getName().equals(mappedTrelloBoardDto.get(0).getName()));
        Assert.assertTrue(trelloBoard.getLists().get(0).getId().equals(mappedTrelloBoard.get(0).getLists().get(0).getId()));
        Assert.assertTrue(trelloBoard.getLists().get(0).getId().equals(mappedTrelloBoardDto.get(0).getLists().get(0).getId()));
    }
}