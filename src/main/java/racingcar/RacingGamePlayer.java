package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.RacingGameNavigation.*;

public class RacingGamePlayer {

    private static final String CAR_NAME_JOIN_DELIMITER = ",";

    public RacingCars ready() {
        System.out.println(CAR_NAME_NAVIGATION);
        CarNamesCreator carNamesCreator = new UserInputCarNamesCreator();
        List<CarName> carNames = carNamesCreator.create();

        RacingCarsCreator racingCarsCreator = new ThresholdRacingCarCreator();
        return racingCarsCreator.createByCarNames(carNames);
    }

    public RacingCars play(RacingCars racingCars) {
        System.out.println(TRY_NUMBER_NAVIGATION);
        RacingCarsMover racingCarsMover = new RandomRacingCarsMover();
        int totalTryNumber = Integer.parseInt(readLine());
        System.out.println();

        return racingCarsMover.moveForwardManyTimes(racingCars, totalTryNumber);
    }

    public void ending(RacingCars racingCars) {
        RacingWinnerFinder racingWinnerFinder = new RacingWinnerFinder();
        RacingCars racingWinners = racingWinnerFinder.find(racingCars);

        String winnerNamesWithJoin = racingWinners.getCarNamesWithJoin(CAR_NAME_JOIN_DELIMITER);
        System.out.print(FINAL_WINNER_NAVIGATION);
        System.out.println(winnerNamesWithJoin);
    }
}
