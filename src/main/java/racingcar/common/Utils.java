package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
