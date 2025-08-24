package com.theyvison.dslist.services;

import com.theyvison.dslist.dto.GameMinDTO;
import com.theyvison.dslist.entities.Game;
import com.theyvison.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired // injeta a dependência
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        // transforma a lista de Game em lista de GameMinDTO
        // stream faz um loop na lista e map transforma cada elemento da lista
        return dto;
    }
}
