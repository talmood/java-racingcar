package racingcar.view;

public class SystemOutputPrinter implements OutputPrinter {

    @Override
    public void printLine(final String outputMessage) {
        System.out.println(outputMessage);
    }

}
