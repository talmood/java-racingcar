package racingcar;

public class RacingWinnerFinder {

    public RacingCars find(RacingCars racingCars) {
        RacingCar maxLocationCar = racingCars.findMaxLocationCar();
        return racingCars.findSameLocationCar(maxLocationCar);
    }
}
