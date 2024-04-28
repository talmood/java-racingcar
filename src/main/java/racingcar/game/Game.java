package racingcar.game;

import racingcar.common.Utils;
import racingcar.game.user.User;
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
        this.numberOfPlayRound = userInputScan.getRound();
        this.users = Arrays.stream(userInputScan.getUserNames()).map(User::new).toList();
    }

    public int getNumberOfPlayRound() {
        return numberOfPlayRound;
    }

    public List<User> getUsers() {
        return users;
    }

    public void start() {
        startGame();
        displayWinner();
    }

    private void startGame() {
        final Round round = new Round(this);
        round.start();
    }

    private void displayWinner() {
        final int bestScore = Utils.findBestScore(users.stream().map(user -> user.getCar().getPosition()).toList());
        final List<String> bestUserNames = Utils.findBestUser(users, bestScore).stream().map(User::getName).toList();
        UserOutputDisplay.planText(String.format("최종 우승자 : %s", String.join(",", bestUserNames)));
    }
}
