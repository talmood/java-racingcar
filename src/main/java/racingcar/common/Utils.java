package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.constant.LimitValue;
import racingcar.game.user.User;

import java.util.List;

public class Utils {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(LimitValue.MIN_RANDOM_RANGE, LimitValue.MAX_RANDOM_RANGE);
    }

    public static int findBiggestNumber(final List<Integer> numbers) {
        return numbers.stream().mapToInt(number->number).max()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMsg.INVALID_POSITION));
    }

    public static List<User> findBestUser(List<User> users, final int bestScore) {
        return users.stream()
                .filter(user -> user.getCar().getPosition() == bestScore)
                .toList();
    }
}
