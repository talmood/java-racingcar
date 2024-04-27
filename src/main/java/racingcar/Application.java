package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingGameInitializer gameInitializer = new RacingGameInitializer();
        RacingGame racingGame = gameInitializer.initializeGame();
        racingGame.runRace();
    }
}
