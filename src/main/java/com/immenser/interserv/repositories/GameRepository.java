package com.immenser.interserv.repositories;

import com.immenser.interserv.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
