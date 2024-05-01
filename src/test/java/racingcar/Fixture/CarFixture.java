package racingcar.Fixture;

import racingcar.common.constant.LimitValue;

public class CarFixture {
    public static int getLowerForwardThreshold(){
        return LimitValue.CAR_AVAILABLE_MOVE_THRESHOLD - 1;
    }

    public static int getEqualForwardThreshold(){
        return LimitValue.CAR_AVAILABLE_MOVE_THRESHOLD;
    }

    public static int getUpperForwardThreshold(){
        return LimitValue.CAR_AVAILABLE_MOVE_THRESHOLD + 1;
    }
}
