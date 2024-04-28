package racingcar.controller;

import racingcar.model.RacingCarNames;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        final RacingCarNames carNames = inputView.inputCarNames();
    }

}
