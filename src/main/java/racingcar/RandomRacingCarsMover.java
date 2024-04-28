package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.RacingGameNavigation.MOVE_RESULT_NAVIGATION;

public class RandomRacingCarsMover implements RacingCarsMover {
    @Override
    public RacingCars moveForward(RacingCars racingCars) {
        racingCars = racingCars.moveAllCarsForwardByRandomValue();
        System.out.println(MOVE_RESULT_NAVIGATION);
        racingCars.printRacingCars();

        return racingCars;
    }

    @Override
    public RacingCars moveForwardManyTimes(RacingCars racingCars) {
        int totalTryNumber = Integer.parseInt(readLine());
        System.out.println();
        for (int i = 0; i < totalTryNumber; i++) {
            racingCars = this.moveForward(racingCars);
            System.out.println();
        }

        return racingCars;
    }
}
