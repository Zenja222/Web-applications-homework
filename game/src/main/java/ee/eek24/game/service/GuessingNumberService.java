package ee.eek24.game.service;

import ee.eek24.game.dto.GameDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GuessingNumberService {
    private int id = 1;
    private final Map<Integer, GameDto> games = new HashMap<>();


    public int startGame(){
        int gameId = id++;
        GameDto game = new GameDto();
        game.setGameID(gameId);
        game.setNumber(new Random().nextInt(100)+1);
        games.put(gameId,game);
        return gameId;
    }

    public String gameProcess(int gameID, int numbers){
        GameDto game = games.get(gameID);
        if(game == null){
            return "Invalid game";
        }

        if(numbers < game.getNumber()) {
            return "Number is smaller";
        } else if (numbers > game.getNumber()) {
            return "Number is bigger";
        } else {
            games.remove(gameID);
            return "You won!";
        }
    }

}
