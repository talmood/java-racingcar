package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.user.User;

import java.util.List;

public class Utils {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_RANGE, Constant.MAX_RANDOM_RANGE);
    }

    public static int findBestScore(final List<Integer> scores) {
        int bestScore = -1;
        for (final int targetScore : scores) {
            if (targetScore > bestScore) {
                bestScore = targetScore;
            }
        }
        return bestScore;
    }

    public static List<User> findBestUser(List<User> users, final int bestScore) {
        return users.stream().filter(user -> user.getCar().getPosition() == bestScore).toList();
    }
}
