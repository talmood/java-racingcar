package racingcar.game;

import racingcar.common.Utils;
import racingcar.game.user.User;
import racingcar.io.UserOutputDisplay;

import java.util.List;

public class Round {
    private final Game game;

    public Round(Game game) {
        this.game = game;
    }

    public void start() {
        for (int round = 0; round < game.getNumberOfPlayRound(); round++) {
            playRound();
            displayRoundStatus();
        }
    }

    private void playRound() {
        for (final User targetUser : game.getUsers()) {
            targetUser.getCar().forward(Utils.getRandomNumber());
        }
    }

    private void displayRoundStatus() {
        displayUser(game.getUsers());
        UserOutputDisplay.newLine();
    }

    private void displayUser(final List<User> users) {
        for (final User targetUser : users) {
            targetUser.displayStatus();
        }
    }

}
