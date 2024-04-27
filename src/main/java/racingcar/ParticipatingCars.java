package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ParticipatingCars {
    private final List<Car> cars;

    public ParticipatingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        final int maxPosition = getMaxPosition();
        return getNamesAtPosition(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = Integer.MIN_VALUE;
        for (final Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> getNamesAtPosition(final int position) {
        final List<String> winners = new ArrayList<>();
        for (final Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
