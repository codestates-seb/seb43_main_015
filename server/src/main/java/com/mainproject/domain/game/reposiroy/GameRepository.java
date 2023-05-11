package com.mainproject.domain.game.reposiroy;

import com.mainproject.domain.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
