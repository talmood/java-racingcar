package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputUtil {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";

    public static int getInteger() {
        String userInput = readLine();
        if (!Pattern.matches(ONLY_NUMBER_REGEX, userInput)) {
            throw new IllegalArgumentException("this input allowed only number");
        }

        return Integer.parseInt(userInput);
    }

    public static String getString() {
        String userInput = readLine();
        if (StringUtils.isBlank(userInput)) {
            throw new IllegalArgumentException("this input must not be blank");
        }

        return userInput;
    }
}
