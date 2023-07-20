package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;

public record GameListDTO(
        Long id,
        String name
) {
    public GameListDTO (GameList list){
        this(list.getId(), list.getName());
    }

}
