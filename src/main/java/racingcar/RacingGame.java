package racingcar;

import java.util.List;

public class RacingGame {

    private final ParticipatingCars participatingCars;
    private final int rounds;

    public RacingGame(final ParticipatingCars participatingCars, final int rounds) {
        validateRounds(rounds);
        this.participatingCars = participatingCars;
        this.rounds = rounds;
    }

    public void runRace() {

        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            conductRound();
        }
        announceWinners();
    }

    private void conductRound() {
        for (final Car car : participatingCars.getCars()) {
            car.moveForward();
            displayCarPosition(car);
        }
        System.out.println();
    }

    private void displayCarPosition(final Car car) {
        final String carPosition = "-".repeat(car.getPosition());
        System.out.println(car.getName() + " : " + carPosition);
    }


    private void announceWinners() {
        final List<String> winners = participatingCars.getWinnerNames();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private void validateRounds(final int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드는 양의 정수여야 합니다.");
        }
    }
}
