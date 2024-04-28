package racingcar;

import racingcar.controller.RacingGameManager;
import racingcar.domain.game.RacingGame;

public class Application {
    public static void main(String[] args) {
        final RacingGameManager racingGameManager = new RacingGameManager();
        final RacingGame racingGame = racingGameManager.prepareRacingGame();
        racingGame.race();
    }
}
