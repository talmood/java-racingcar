package racingcar.game.user;

import racingcar.common.ExceptionMsg;
import racingcar.common.constant.LimitValue;

public class Car {

    private int position;

    public Car(final int position) {
        validationPosition(position);
        this.position = position;
    }

    public static Car copy(final Car car){
        return new Car(car.getPosition());
    }

    public int getPosition() {
        return position;
    }

    public void forward(final int randomNumber){
        if(checkAvailableMoveFlag(randomNumber)){
            this.position +=1;
        }
    }

    private boolean checkAvailableMoveFlag(final int randomNumber){
        return randomNumber > LimitValue.CAR_AVAILABLE_MOVE_THRESHOLD;
    }

    private void validationPosition(final int position){
        if(position < 0){
            throw new IllegalArgumentException(ExceptionMsg.NEGATIVE_POSITION);
        }
    }
}
