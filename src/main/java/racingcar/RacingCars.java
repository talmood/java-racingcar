package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private static final int START_INCLUSIVE_RANDOM_VALUE = 0;
    private static final int END_INCLUSIVE_RANDOM_VALUE = 9;
    
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        if (CollectionUtils.isEmpty(racingCars)) {
            throw new IllegalArgumentException("car names must not be empty");
        }

        this.racingCars = racingCars;
    }

    public static RacingCars create(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public RacingCars moveAllCarsForwardByRandomValue() {
        return new RacingCars(
                this.racingCars.stream()
                        .map(racingCar -> {
                            int randomValue = Randoms.pickNumberInRange(START_INCLUSIVE_RANDOM_VALUE, END_INCLUSIVE_RANDOM_VALUE);
                            return racingCar.moveForwardByValue(randomValue);
                        })
                        .toList()
        );
    }

    public void printRacingCars() {
        this.racingCars.forEach(RacingCar::printRacingCar);
    }

    public RacingCar findMaxLocationCar() {
        return Collections.max(this.racingCars, (o1, o2) -> o1.getNowLocation() - o2.getNowLocation());
    }

    public RacingCars findSameLocationCar(RacingCar compareTo) {
        return new RacingCars(this.racingCars.stream()
                .filter(compareTo::isSameLocation)
                .toList());
    }

    public String getCarNamesWithJoin(String delimiter) {
        String[] names = this.racingCars.stream()
                .map(RacingCar::getCarName)
                .toArray(String[]::new);

        return String.join(delimiter, names);
    }
}
