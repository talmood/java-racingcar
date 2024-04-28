package racingcar;

import java.util.List;

public class UserInputCarNamesCreator implements CarNamesCreator {

    @Override
    public List<CarName> create() {
        String userInput = UserInputUtil.getString();
        StringSplitter splitter = new CommaStringSplitter();
        List<String> splitInput = splitter.split(userInput);

        return splitInput.stream()
                .map(CarName::create)
                .toList();
    }
}
