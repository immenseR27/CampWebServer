package com.immenser.interserv.services;

import com.immenser.interserv.models.Game;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GroupService groupService;

    public Game findGame(Long id) {
        return gameRepository.findById(id).orElseThrow();
    }

    public List<Game> findGamesByAge(long employeeId) {
        Group group = groupService.findGroupByEmployee(employeeId);
        return gameRepository.findGamesByAges(group.getAge());
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }
}

