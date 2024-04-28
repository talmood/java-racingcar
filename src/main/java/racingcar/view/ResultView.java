package racingcar.view;

import racingcar.model.RacingCars;

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

}
