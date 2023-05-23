package com.mainproject.domain.game.service;

import com.mainproject.domain.game.entity.Game;
import com.mainproject.domain.game.reposiroy.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> findAllGameInfo() {
        return gameRepository.findAll();
    }


}
