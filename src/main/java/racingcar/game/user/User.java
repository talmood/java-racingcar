package racingcar.game.user;

import racingcar.common.Constant;
import racingcar.common.ExceptionMsg;
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
        this.car = new Car(Constant.INIT_CAR_POSITION);
    }

    public Car getCar() {
        return car;
    }

    private void validationName(final String name) {
        if (name.length() > Constant.MAX_USER_NAME || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMsg.USER_NAME_MAX_LENGTH);
        }
    }

    public void displayStatus(){
        final String message = String.format("%s : %s", name, Constant.DISPLAY_POSITION_MARK.repeat(car.getPosition()));
        UserOutputDisplay.planText(message);
    }
}
