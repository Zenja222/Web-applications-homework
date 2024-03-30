package ee.eek24.game.controller;

import ee.eek24.game.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ee.eek24.game.service.GuessingNumberService;

@RestController
@RequiredArgsConstructor
public class GuessingNumberController {
    private final GuessingNumberService guessingNumberService;
    @PostMapping("/game")
    public Game create(){
        return guessingNumberService.create();
    }

    @GetMapping("/{game_id}/guess/{number}")
    public String guessNumber(@PathVariable("game_id") int gameId, @PathVariable("number") Long number){
        return guessingNumberService.gameProcess(gameId, number);
    }
}