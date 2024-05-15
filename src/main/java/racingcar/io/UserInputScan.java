package racingcar.io;

import racingcar.common.ExceptionMsg;
import racingcar.common.constant.Placeholder;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputScan {
    private String[] userNames;
    private int numberOfPlayRound;

    public String[] getUserNames() {
        return userNames;
    }

    public int getRound() {
        return numberOfPlayRound;
    }

    public void scan() {
        System.out.println(Placeholder.PLACEHOLDER_NAME);
        this.userNames = validationUserName(readLine());
        System.out.println(Placeholder.PLACEHOLDER_ROUND);
        this.numberOfPlayRound = validationNumberOfPlayRound(readLine());
    }

    public String[] validationUserName(final String userInputName) {
        try {
            return userInputName.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMsg.WRONG_STRING_TYPE);
        }
    }

    public int validationNumberOfPlayRound(final String numberOfPlayRound) {
        try {
            final int round = Integer.parseInt(numberOfPlayRound);
            if (round < 0) {
                throw new IllegalArgumentException(ExceptionMsg.NEGATIVE_NUMBER_OF_PLAY_ROUND);
            }
            return round;
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMsg.NAN);
        }
    }
}