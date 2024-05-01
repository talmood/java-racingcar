package racingcar.game;

import racingcar.common.Utils;
import racingcar.game.user.User;
import racingcar.io.UserOutputDisplay;

import java.util.ArrayList;
import java.util.List;


public class Round {
    private int roundNumber;
    private List<User> users = new ArrayList<>();

    public Round(int roundNumber, List<User> users) {
        this.roundNumber = roundNumber;
        for (User user: users) {
            this.users.add(user.UserCopy());
            System.out.println("user.getName() = " + user.getName());
            System.out.println("user.getCar().getPosition() = " + user.getCar().getPosition());
            System.out.println();
        }
    }

    public void start() {
        for (final User targetUser : users) {
            targetUser.getCar().forward(Utils.getRandomNumber());
        }
    }

    public List<User> getUsers() {
        final List<User> userList = new ArrayList<>();
        for (User user: users) {
            userList.add(user.UserCopy());
        }
        return userList;
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
