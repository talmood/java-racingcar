package racingcar;

import racingcar.common.Utils;
import racingcar.io.UserInputScan;

import java.util.Arrays;
import java.util.List;

public class Game {
    private int numberOfPlayRound;
    private List<Car> cars;

    public void init() {
        final UserInputScan userInputScan = new UserInputScan();
        userInputScan.scan();
        this.numberOfPlayRound = userInputScan.getNumberOfPlayGame();
        this.cars = Arrays.stream(userInputScan.getUserNames()).map(Car::new).toList();
    }

    public void start() {
        for (int round = 0; round < numberOfPlayRound; round++) {
            playRound();
            displayRoundStatus();
        }
    }

    private void playRound() {
        for (final Car targetCar : cars) {
            targetCar.forward(Utils.getRandomNumber());
        }
    }

    private void displayRoundStatus() {
        for (final Car targetCar : cars) {
            targetCar.displayStatus();
        }
        System.out.println();
    }
}
