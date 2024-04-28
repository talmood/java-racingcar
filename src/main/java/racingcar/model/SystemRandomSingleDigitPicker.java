package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class SystemRandomSingleDigitPicker implements RandomSingleDigitPicker {

    @Override
    public int pick() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
