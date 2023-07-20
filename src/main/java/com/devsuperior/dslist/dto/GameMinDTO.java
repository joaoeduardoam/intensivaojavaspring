package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public record GameMinDTO(

        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription
) {
    public GameMinDTO (Game game){
        this (game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }

    public GameMinDTO (GameMinProjection projection){
        this (projection.getId(), projection.getTitle(), projection.getYear(), projection.getImgUrl(), projection.getShortDescription());
    }
}
