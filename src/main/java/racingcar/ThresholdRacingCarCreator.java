package racingcar;

import java.util.List;

public class ThresholdRacingCarCreator implements RacingCarsCreator {

    @Override
    public RacingCars createByCarNames(List<CarName> carNames) {
        List<RacingCar> racingCars = carNames.stream()
                .map(carName -> RacingCar.create(carName, new ThresholdCondition()))
                .toList();

        return RacingCars.create(racingCars);
    }
}
