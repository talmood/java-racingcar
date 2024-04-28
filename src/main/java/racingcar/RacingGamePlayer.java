package racingcar;

import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.RacingGameNavigation.*;

public class RacingGamePlayer {

    private static final String CAR_NAME_JOIN_DELIMITER = ",";
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";

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
        String userTryInput = readLine();
        if (!Pattern.matches(ONLY_NUMBER_REGEX, userTryInput)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
        int totalTryNumber = Integer.parseInt(userTryInput);
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
