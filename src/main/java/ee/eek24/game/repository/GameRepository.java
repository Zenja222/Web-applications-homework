package ee.eek24.game.repository;

import ee.eek24.game.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAll();

}
