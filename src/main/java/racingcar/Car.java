package racingcar;

import racingcar.common.Constant;

public class Car {
    private String name;

    public Car(String name) {
        validationName(name);
        this.name = name;
    }

    private void validationName(final String name) {
        if (name.length() > Constant.MAX_USER_NAME) {
            throw new IllegalArgumentException();
        }
    }
}
