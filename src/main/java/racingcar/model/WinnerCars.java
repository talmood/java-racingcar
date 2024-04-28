package racingcar.model;

import java.util.List;

public class WinnerCars {

    private final List<RacingCar> cars;

    public WinnerCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

}
