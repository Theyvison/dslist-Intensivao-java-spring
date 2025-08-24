package com.theyvison.dslist.services;

import com.theyvison.dslist.dto.GameListDTO;
import com.theyvison.dslist.entities.GameList;
import com.theyvison.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(list -> new GameListDTO(list)).toList();
        return dto;
    }
}
