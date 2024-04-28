package racingcar.mock;

import racingcar.view.InputReader;

public class FakeInputReader implements InputReader {

    private final String inputMessage;

    public FakeInputReader(final String inputMessage) {
        this.inputMessage = inputMessage;
    }

    @Override
    public String readLine() {
        return this.inputMessage;
    }

}
