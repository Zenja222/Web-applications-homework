package ee.eek24.game.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ee.eek24.game.service.GuessingNumberService;

@RestController
@RequiredArgsConstructor
public class GuessingNumberController {
    private final GuessingNumberService guessingNumberService;

    @PostMapping("/game")
    public int startGame(){
        return guessingNumberService.startGame();
    }

    @GetMapping("/{game_id}/guess/{number}")
    public String guessNumber(@PathVariable("game_id") int gameID, @PathVariable("number") int number){
        return guessingNumberService.gameProcess(gameID, number);
    }

}
