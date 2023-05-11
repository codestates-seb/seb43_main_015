package com.mainproject.domain.game.controller;

import com.mainproject.domain.game.entity.Game;
import com.mainproject.domain.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity findAllGameInfo() {
        List<Game> allGameInfo = gameService.findAllGameInfo();

        return new ResponseEntity<>(allGameInfo, HttpStatus.OK);

    }


}
