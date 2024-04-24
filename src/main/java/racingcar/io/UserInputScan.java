package racingcar.io;

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
        this.userNames = validationUserName(readLine());
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