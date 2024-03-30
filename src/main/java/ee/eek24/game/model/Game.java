package ee.eek24.game.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Table(name = "game")
public class Game {

    @Id
    private Long game_id;
    private Integer number;

}
