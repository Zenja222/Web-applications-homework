package ee.eek24.game.service;

import ee.eek24.game.dto.GameDto;
import ee.eek24.game.mapper.GameMapper;
import ee.eek24.game.model.Game;
import ee.eek24.game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GuessingNumberService {

    private final GameRepository gameRepository;

    public Game create() {
        Game game = new Game();
        game.setNumber(new Random().nextInt(100) + 1);
        return gameRepository.save(game);
    }

    public List<GameDto> getAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMapper::toDto)
                .collect(Collectors.toList());
    }

    public String gameProcess(int number, Long gameId) {
        GameDto game = findById(gameId);
        if (game == null) {
            return "Invalid game";
        }

        if (number < game.getNumber()) {
            return "Number is smaller";
        } else if (number > game.getNumber()) {
            return "Number is bigger";
        } else {
            return "You won!";
        }
    }

    public GameDto findById(Long id) {
        Game game = requireGame(id);
        return GameMapper.toDto(game);
    }

    private Game requireGame(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
    }
}