package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.*;

public class Application {

    public static void main(String[] args) {
        final InputReader inputReader = new SystemInputReader();
        final OutputPrinter outputPrinter = new SystemOutputPrinter();

        final InputView inputView = new InputView(inputReader, outputPrinter);
        final ResultView resultView = new ResultView(outputPrinter);

        new RacingGameController(inputView, resultView).startGame();
    }

}
