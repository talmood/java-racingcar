package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class SystemInputReader implements InputReader {

    @Override
    public String readLine() {
        return Console.readLine().trim();
    }

}
