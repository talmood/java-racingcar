package racingcar.Fixture;

import racingcar.common.Constant;

public class CarFixture {
    public static int getLowerForwardThreshold(){
        return Constant.CAR_AVAILABLE_MOVE_THRESHOLD - 1;
    }

    public static int getEqualForwardThreshold(){
        return Constant.CAR_AVAILABLE_MOVE_THRESHOLD;
    }

    public static int getUpperForwardThreshold(){
        return Constant.CAR_AVAILABLE_MOVE_THRESHOLD + 1;
    }
}
