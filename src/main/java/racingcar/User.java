package racingcar;

import racingcar.common.Constant;
import racingcar.io.UserOutputDisplay;

public class User {
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public User(String name) {
        validationName(name);
        this.name = name;
        this.car = new Car(0);
    }

    public Car getCar() {
        return car;
    }

    private void validationName(final String name) {
        if (name.length() > Constant.MAX_USER_NAME) {
            throw new IllegalArgumentException();
        }
    }

    public void displayStatus(){
        final String message = String.format("%s : %s", name, Constant.DISPLAY_POSITION_MARK.repeat(car.getPosition()));
        UserOutputDisplay.planText(message);
    }
}
