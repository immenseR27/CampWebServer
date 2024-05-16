package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Game;
import com.immenser.interserv.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findGame(@PathVariable Long id) {
        return gameService.findGame(id);
    }
}
