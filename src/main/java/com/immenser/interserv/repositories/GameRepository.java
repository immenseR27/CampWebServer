package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Age;
import com.immenser.interserv.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findGamesByAges(Age age);
}
