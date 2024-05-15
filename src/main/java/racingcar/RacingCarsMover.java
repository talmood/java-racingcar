package racingcar;

public interface RacingCarsMover {

    RacingCars moveForward(RacingCars racingCars);

    RacingCars moveForwardManyTimes(RacingCars racingCars, int totalTryNumber);

}
