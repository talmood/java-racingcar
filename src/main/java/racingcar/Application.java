package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingGamePlayer racingGamePlayer = new RacingGamePlayer();
        RacingCars readyRacingCars = racingGamePlayer.ready();
        RacingCars playedRacingCars = racingGamePlayer.play(readyRacingCars);
        racingGamePlayer.ending(playedRacingCars);

        System.out.println("test");
    }
}
