package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {

        List<GameList> result = gameListRepository.findAll();

        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();

       return dto;
    }

    @Transactional
    public void move(Long idList, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(idList);

        GameMinProjection gameMoving = list.remove(sourceIndex);
        list.add(destinationIndex, gameMoving);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(idList, list.get(i).getId(), i);
        }



    }


}
