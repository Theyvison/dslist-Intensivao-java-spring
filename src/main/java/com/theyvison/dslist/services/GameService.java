package com.theyvison.dslist.services;

import com.theyvison.dslist.dto.GameDTO;
import com.theyvison.dslist.dto.GameMinDTO;
import com.theyvison.dslist.entities.Game;
import com.theyvison.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired // injeta a dependência
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // transactional -> gerencia a transação com o banco de dados, readOnly -> não faz lock no banco de dados
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO gameDTO = new GameDTO(result);
        return gameDTO;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        // transforma a lista de Game em lista de GameMinDTO
        // stream faz um loop na lista e map transforma cada elemento da lista
        return dto;
    }
}
