package racingcar.game;

import racingcar.common.Utils;
import racingcar.game.user.User;
import racingcar.io.UserOutputDisplay;

import java.util.ArrayList;
import java.util.List;


public class Round {
    private int roundNumber;
    final private List<User> users = new ArrayList<>();

    public Round(int roundNumber, List<User> users) {
        this.roundNumber = roundNumber;
        for (User user: users) {
            this.users.add(User.UserCopy(user));
        }
    }

    public void start() {
        for (final User targetUser : users) {
            targetUser.getCar().forward(Utils.getRandomNumber());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void displayRoundStatus() {
        displayUser(users);
        UserOutputDisplay.newLine();
    }

    private void displayUser(final List<User> users) {
        for (final User targetUser : users) {
            targetUser.displayStatus();
        }
    }
}
