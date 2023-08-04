package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public record GameReplacementDTO(

        int sourceIndex,
        int destinationIndex
) {

}
