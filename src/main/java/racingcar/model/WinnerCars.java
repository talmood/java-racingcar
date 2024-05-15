package racingcar.model;

import java.util.List;

public class WinnerCars {

    private final List<RacingCar> cars;

    public WinnerCars(List<RacingCar> cars) {
        validateWinnerCarPolicy(cars);
        this.cars = cars;
    }

    private void validateWinnerCarPolicy(final List<RacingCar> cars) {
        final long distinctNumOfMoveForwardCounts = cars.stream()
                .mapToInt(RacingCar::getNumOfMovedForward)
                .distinct()
                .count();

        if (distinctNumOfMoveForwardCounts > 1) {
            throw new IllegalArgumentException("All number of moved forward of winner cars must be same.");
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

}
