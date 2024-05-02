package racingcar.Fixture;

import racingcar.common.constant.DisplayValue;
import racingcar.common.constant.LimitValue;
import racingcar.game.user.User;

public class UserFixture {

    public static String getValidLengthName(){
        return "ray";
    }

    public static String getInvalidLengthName(){
        return "hyeongy";
    }

    public static String getEmptyName(){
        return "";
    }

    public static User getValidUser(){
        return new User(getValidLengthName());
    }

    public static String getUserStatusText(final User user){
        return String.format("%s : %s",  user.getName(), DisplayValue.DISPLAY_POSITION_MARK.repeat(user.getCar().getPosition())).trim();
    }

    public static User getForwardValidUser(){
        User user = getValidUser();
        user.getCar().forward(LimitValue.CAR_AVAILABLE_MOVE_THRESHOLD+1);
        return user;
    }
}
