package com.immenser.interserv.controllers;

import com.immenser.interserv.models.Game;
import com.immenser.interserv.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> findGamesByAge(@RequestParam("employeeId") long employeeId) {
        return gameService.findGamesByAge(employeeId);
    }

    @GetMapping("/{id}")
    public Game findGame(@PathVariable Long id) {
        return gameService.findGame(id);
    }

    @PostMapping
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }
}
