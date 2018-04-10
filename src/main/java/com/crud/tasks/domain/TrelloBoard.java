package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.RequestGroupInfo;

import java.util.List;

@Getter
@AllArgsConstructor
public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList> lists;
}
