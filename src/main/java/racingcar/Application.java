package racingcar;

import racingcar.game.Game;

public class Application {
    public static void main(String[] args) {
        final Game game = new Game();
        game.init();
        game.start();
    }
}
