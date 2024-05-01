package racingcar.game.user;

import racingcar.common.ExceptionMsg;
import racingcar.common.constant.DisplayValue;
import racingcar.common.constant.LimitValue;
import racingcar.io.UserOutputDisplay;

public class User{
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public User(final String name) {
        validationName(name);
        this.name = name;
        this.car = new Car(LimitValue.INIT_CAR_POSITION);
    }

    public User UserCopy(){
        final User coypUser = new User(this.getName());
        coypUser.setCar(this.getCar());
        return coypUser;
    }

    public Car getCar() {
        return car;
    }

    private void setCar(final Car car){
        this.car = car;
    }

    private void validationName(final String name) {
        if (name.length() > LimitValue.MAX_USER_NAME || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMsg.USER_NAME_MAX_LENGTH);
        }
    }

    public void displayStatus(){
        UserOutputDisplay.userStatus(this);
    }
}
