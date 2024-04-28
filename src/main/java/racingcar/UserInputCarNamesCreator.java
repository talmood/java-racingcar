package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputCarNamesCreator implements CarNamesCreator {

    @Override
    public List<CarName> create() {
        String userInput = readLine();
        StringSplitter splitter = new CommaStringSplitter();
        List<String> splitInput = splitter.split(userInput);

        return splitInput.stream()
                .map(CarName::create)
                .toList();
    }
}
