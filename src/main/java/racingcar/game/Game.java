package racingcar.game;

import racingcar.common.Utils;
import racingcar.game.user.User;
import racingcar.io.UserInputScan;
import racingcar.io.UserOutputDisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int numberOfPlayRound;
    private List<User> users;
    private final List<Round> rounds = new ArrayList<>();

    public void init() {
        scanUserInput();
    }

    public void start() {
        startGame();
        displayRoundResult();
        displayWinner();
    }

    private void scanUserInput() {
        final UserInputScan userInputScan = new UserInputScan();
        userInputScan.scan();
        this.numberOfPlayRound = userInputScan.getRound();
        this.users = Arrays.stream(userInputScan.getUserNames()).map(User::new).toList();
    }

    private void startGame() {
        for (int roundNumber = 0; roundNumber < numberOfPlayRound; roundNumber++) {
            final Round round = new Round(roundNumber, users);
            round.start();
            updateUserStatus(round);
            rounds.add(round);
        }
    }

    private void updateUserStatus(final Round round) {
        users = round.getUsers();
    }

    private void displayRoundResult() {
        for (Round round : rounds) {
            round.displayRoundStatus();
        }
    }

    private void displayWinner() {
        final int bestScore = Utils.findBiggestNumber(users.stream().map(user -> user.getCar().getPosition()).toList());
        final List<String> bestUserNames = Utils.findBestUser(users, bestScore).stream().map(User::getName).toList();
        UserOutputDisplay.planText(String.format("최종 우승자 : %s", String.join(",", bestUserNames)));
    }
}
