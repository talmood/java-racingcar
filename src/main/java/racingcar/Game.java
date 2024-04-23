package racingcar;

import racingcar.io.UserInputScan;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private int numberOfPlayGame;
    private List<Car> cars;


    public void start(int numberOfPlayGame) {
        final UserInputScan userInputScan =  new UserInputScan();
        System.out.println("userInputScan.getUserNames() = " + userInputScan.getUserNames());
    }


}
