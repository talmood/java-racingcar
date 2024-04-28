package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RandomRacingCarsMover implements RacingCarsMover {
    @Override
    public RacingCars moveForward(RacingCars racingCars) {
        racingCars = racingCars.moveAllCarsForwardByRandomValue();

        System.out.println();
        System.out.println("실행 결과");

        racingCars.printRacingCars();

        System.out.println();

        return racingCars;
    }

    @Override
    public RacingCars moveForwardManyTimes(RacingCars racingCars) {
        int totalTryNumber = Integer.parseInt(readLine());

        for (int i = 0; i < totalTryNumber; i++) {
            racingCars = this.moveForward(racingCars);
        }

        return racingCars;
    }
}
