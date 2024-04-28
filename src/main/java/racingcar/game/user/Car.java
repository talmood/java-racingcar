package racingcar.game.user;

import racingcar.common.Constant;

public class Car {

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void forward(int randomNumber){
        if(checkAvailableMoveFlag(randomNumber)){
            this.position +=1;
        }
    }

    private boolean checkAvailableMoveFlag(int randomNumber){
        return randomNumber > Constant.CAR_AVAILABLE_MOVE_THRESHOLD;
    }
}
