package racingcar;

import java.util.List;

public interface RacingCarsCreator {

    RacingCars createByCarNames(List<CarName> carNames);
}
