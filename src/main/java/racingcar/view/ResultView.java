package racingcar.view;

import racingcar.model.RacingCars;
import racingcar.model.WinnerCars;

public class ResultView {

    private final OutputPrinter outputPrinter;

    public ResultView(final OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    public void printResultGuide() {
        outputPrinter.printLine("실행 결과");
    }

    public void printGameStatus(final RacingCars cars) {
        outputPrinter.printLine(ResultViewFormatter.formatGameStatus(cars));
        outputPrinter.printEmptyLine();
    }

    public void printWinnerCars(final WinnerCars cars) {
        outputPrinter.printLine(ResultViewFormatter.formatWinnerCars(cars));
    }

}
