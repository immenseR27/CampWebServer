package com.immenser.interserv.services;

import com.immenser.interserv.models.Game;
import com.immenser.interserv.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public List<Game> findByUser(Long userId) {
        return gameRepository.findAll();
    }

    public Game findGame(Long id) {
        return gameRepository.findById(id).orElseThrow();
    }
}
