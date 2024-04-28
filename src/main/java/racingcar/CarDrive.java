package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;
import java.util.Set;

public class CarDrive implements Drive {

    @Override
     public Map<String, Integer> runCarsForTrialTimes(String[] carNames, int trialTimes) {

        Map<String, Integer> mileageForCar = ScoreWinner.createMileageForCar(carNames);

        for (int i = 0; i < trialTimes; i++) {
            runCars(mileageForCar);
            System.out.println();
        }
        return mileageForCar;

    }
    private void runCars(Map<String, Integer> mileageForCar) {
        Set<String> carNames = mileageForCar.keySet();

        for (String carName : carNames) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            printDashByRandomNumberForCar(carName,randomNumber);
            ScoreWinner.incrementMileageIfCarCanGoForward(carName, randomNumber, mileageForCar);
        }

    }

    static boolean canGoForward(int randomNumber) {
        return randomNumber > 3;
    }

    private void printDashByRandomNumberForCar(String carNames, int randomNumber) {
        StringBuilder dashForRandomNumber = new StringBuilder();
        for (int i = 0; i < randomNumber; i++) {
            dashForRandomNumber.append("-");
        }
        System.out.println(carNames + " : " +  dashForRandomNumber);
    }

}
