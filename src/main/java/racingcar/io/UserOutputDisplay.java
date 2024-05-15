package racingcar.io;

import racingcar.common.constant.DisplayValue;
import racingcar.game.user.User;

public class UserOutputDisplay {
    public static void planText(final String text){
        System.out.println(text);
    }

    public static void userStatus(final User user){
        final String message = String.format("%s : %s", user.getName(), DisplayValue.DISPLAY_POSITION_MARK.repeat(user.getCar().getPosition()));
        planText(message);
    }

    public static void newLine(){
        System.out.println("");
    }
}