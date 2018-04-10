package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void testTrelloService() throws TaskNotFoundException {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);
        //When
        List<TrelloBoardDto> beforeCall = trelloService.fetchTrelloBoards();
        int beforeCallSize = beforeCall.size();
        trelloBoardDtos.add(trelloBoardDto);
        List<TrelloBoardDto> afterCall = trelloService.fetchTrelloBoards();
        int afterCallSize = afterCall.size();
        //Then
        Assert.assertEquals(0, beforeCallSize);
        Assert.assertEquals(1, afterCallSize);
    }
}