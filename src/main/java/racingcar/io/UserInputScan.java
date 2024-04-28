package racingcar.io;

import racingcar.common.Constant;

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
        System.out.println(Constant.PLACEHOLDER_NAME);
        this.userNames = validationUserName(readLine());
        System.out.println(Constant.PLACEHOLDER_ROUND);
        this.numberOfPlayRound = validationNumberOfPlayRound(readLine());
    }
    public String[] validationUserName(final String userInputName) {
        try {
            return userInputName.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int validationNumberOfPlayRound(final String numberOfPlayRound) {
        try {
            final int round = Integer.parseInt(numberOfPlayRound);
            if (round < 0) {
                throw new IllegalArgumentException();
            }
            return round;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}