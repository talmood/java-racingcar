package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class Application {
    private final UserInputCondition userInputCondition;
    private final Drive drive;
    private final Score score;

    public Application(UserInputCondition userInputCondition, Drive drive, Score score) {
        this.userInputCondition = userInputCondition;
        this.drive = drive;
        this.score = score;
    }

    public void start() {
        String[] carNames = userInputCondition.acceptRacingCarNames();
        int trialTimes = userInputCondition.acceptTrialTimes();
        Map<String, Integer> mileageForCar = drive.runCarsForTrialTimes(carNames, trialTimes);
        score.showWinner(mileageForCar);

        Console.close();
    }

    public static void main(String[] args) {

        UserInputCondition userInput = new UserInput();
        Drive carDriving = new CarDrive();
        Score scoreWinner = new ScoreWinner();

        Application application = new Application(userInput, carDriving, scoreWinner);
        application.start();
    }

}
