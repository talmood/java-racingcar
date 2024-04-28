package racingcar.model;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars;

    RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public static RacingCars fromCarNames(RacingCarNames carNames) {
        final List<RacingCar> cars = carNames.names().stream()
                .map(RacingCar::fromName)
                .toList();

        return new RacingCars(cars);
    }

    public void moveForward(
            final RandomSingleDigitPicker singleDigitPicker,
            final AttemptCount attemptCount
    ) {
        while (attemptCount.hasCount()) {
            cars.forEach(car -> car.goForward(singleDigitPicker));
            attemptCount.deductOneCount();
        }
    }

    public WinnerCars judgeWinnerCars() {
        final List<RacingCar> winnerCars = this.cars.stream()
                .filter(car -> car.matchesNumOfMovedForward(calculateMaxNumOfMovedForward()))
                .toList();

        return new WinnerCars(winnerCars);
    }

    private Integer calculateMaxNumOfMovedForward() {
        return this.cars.stream()
                .map(RacingCar::getNumOfMovedForward)
                .max(Integer::compareTo)
                .orElse(0);
    }

}
