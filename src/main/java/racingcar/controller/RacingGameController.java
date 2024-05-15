package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    private final RandomSingleDigitPicker singleDigitPicker = new SystemRandomSingleDigitPicker();
    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        final RacingCars cars = setUpRacingCars();
        final AttemptCount attemptCount = inputView.inputAttemptCount();

        resultView.printResultGuide();

        while (attemptCount.hasCount()) {
            cars.moveForward(singleDigitPicker);

            resultView.printGameStatus(cars);

            attemptCount.deductOneCount();
        }

        resultView.printWinnerCars(cars.judgeWinnerCars());
    }

    private RacingCars setUpRacingCars() {
        final RacingCarNames carNames = inputView.inputCarNames();
        return RacingCars.fromCarNames(carNames);
    }

}
