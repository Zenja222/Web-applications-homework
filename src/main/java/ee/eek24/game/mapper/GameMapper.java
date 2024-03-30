package ee.eek24.game.mapper;

import ee.eek24.game.dto.GameDto;
import ee.eek24.game.model.Game;

public class GameMapper {

    public static GameDto toDto(Game game) {
        GameDto gameDto = new GameDto();
        gameDto.setNumber(game.getNumber());
        return gameDto;
    }
}