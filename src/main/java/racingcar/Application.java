package racingcar;

import static racingcar.view.InputView.inputCarNamesToRace;
import static racingcar.view.InputView.inputRacingRound;

import racingcar.controller.RacingGameManager;
import racingcar.controller.request.CarNamesRequest;
import racingcar.controller.request.RoundRequest;

public class Application {

    public static void main(String[] args) {
        final CarNamesRequest carNamesRequest = inputCarNamesToRace();
        final RoundRequest roundRequest = inputRacingRound();

        final RacingGameManager racingGameManager = new RacingGameManager();
        racingGameManager.play(carNamesRequest, roundRequest);
    }
}
