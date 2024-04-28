package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingGamePlayer racingGamePlayer = new RacingGamePlayer();
        RacingCars racingCars = racingGamePlayer.ready();
        racingCars = racingGamePlayer.play(racingCars);
        racingGamePlayer.ending(racingCars);
    }
}
