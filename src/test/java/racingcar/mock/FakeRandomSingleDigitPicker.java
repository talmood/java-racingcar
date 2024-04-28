package racingcar.mock;

import racingcar.model.RandomSingleDigitPicker;

public class FakeRandomSingleDigitPicker implements RandomSingleDigitPicker {

    private final int pickedRandomNumber;

    public FakeRandomSingleDigitPicker(int pickedRandomNumber) {
        this.pickedRandomNumber = pickedRandomNumber;
    }

    @Override
    public int pick() {
        return this.pickedRandomNumber;
    }

}
