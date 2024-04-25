package racingcar;

import racingcar.common.Utils;
import racingcar.io.UserInputScan;
import racingcar.io.UserOutputDisplay;

import java.util.Arrays;
import java.util.List;

public class Game {
    private int numberOfPlayRound;
    private List<User> users;

    public void init() {
        final UserInputScan userInputScan = new UserInputScan();
        userInputScan.scan();
        this.numberOfPlayRound = userInputScan.getNumberOfPlayGame();
        this.users = Arrays.stream(userInputScan.getUserNames()).map(User::new).toList();
    }

    public void start() {
        startGame();
        displayWinner();
    }

    private void startGame() {
        for (int round = 0; round < numberOfPlayRound; round++) {
            playRound();
            displayRoundStatus();
        }
    }

    private void playRound() {
        for (final User targetUser : users) {
            targetUser.getCar().forward(Utils.getRandomNumber());
        }
    }

    private void displayUser(final List<User> users) {
        for (final User targetUser : users) {
            targetUser.displayStatus();
        }
    }//최종 우승자 : pobi, jun

    private void displayRoundStatus() {
        displayUser(this.users);
        UserOutputDisplay.newLine();
    }


    private int findBestScore() {
        int bestScore = -1;
        for (final User targetUser : users) {
            if (targetUser.getCar().getPosition() > bestScore) {
                bestScore = targetUser.getCar().getPosition();
            }
        }
        return bestScore;
    }

    private List<User> findBestUser(final int bestScore) {
        return users.stream().filter(user -> user.getCar().getPosition() == bestScore).toList();
    }


    private void displayWinner() {
        final int bestScore = findBestScore();
        final List<String> bestUserNames = findBestUser(bestScore).stream().map(User::getName).toList();
        UserOutputDisplay.planText(String.format("최종 우승자 : %s", String.join(",", bestUserNames)));
    }
}
