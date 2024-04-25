package racingcar.io;

import racingcar.common.Constant;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputScan {
    private String[] userNames;
    private int numberOfPlayGame;

    public String[] getUserNames() {
        return userNames;
    }

    public int getNumberOfPlayGame() {
        return numberOfPlayGame;
    }

    public void scan() {
        System.out.println(Constant.PLACEHOLDER_NAME);
        this.userNames = validationUserName(readLine());
        System.out.println(Constant.PLACEHOLDER_ROUND);
        this.numberOfPlayGame = validationNumberOfPlayGame(readLine());
    }

    private String[] validationUserName(final String userInputName) {
        try {
            return userInputName.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private int validationNumberOfPlayGame(final String userInputNumberOfPlayGame) {
        try {
            final int numberOfPlayGame = Integer.parseInt(userInputNumberOfPlayGame);
            if (numberOfPlayGame < 0) {
                throw new IllegalArgumentException();
            }
            return numberOfPlayGame;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}