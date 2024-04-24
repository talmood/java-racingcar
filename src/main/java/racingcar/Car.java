package racingcar;

import racingcar.common.Constant;
import racingcar.io.UserOutputDisplay;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validationName(name);
        this.name = name;
    }

    public void forward(int randomNumber){
        if(checkAvailableMoveFlag(randomNumber)){
            this.position +=1;
        }
    }

    private boolean checkAvailableMoveFlag(int randomNumber){
        return randomNumber > Constant.CAR_AVAILABLE_MOVE_THRESHOLD;
    }

    private void validationName(final String name) {
        if (name.length() > Constant.MAX_USER_NAME) {
            throw new IllegalArgumentException();
        }
    }

    public void displayStatus(){
        final String message = String.format("%s : %s", name, Constant.DISPLAY_POSITION_MARK.repeat(position));
        UserOutputDisplay.displayPlanText(message);
    }
}
