package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreWinner implements Score {

    static Map<String, Integer> createMileageForCar(String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(carName -> carName,
                        carName -> 0,
                        (existing, replacement) -> {
                            throw new IllegalArgumentException();
                        }));
    }

    static void incrementMileageIfCarCanGoForward(String carName, int randomNumber, Map<String, Integer> mileageForCar) {
        if (CarDrive.canGoForward(randomNumber)) {
            mileageForCar.compute(carName,
                    (key, mileage) -> incrementMileage(mileage));
        };
    }
    static private int incrementMileage(Integer mileage) {
        if (mileage == null) {
            return 1;
        }
        return  mileage + 1;
    }

    @Override
    public void showWinner(Map<String, Integer> mileageForCar) {
        List<String> winners = computeWinner(mileageForCar);
        printWinner(winners);
    }

    private void printWinner(List<String> winners) {

        if (winners.isEmpty()) {
            return;
        }
        String winnerString = "";

        winnerString = winners.stream()
                .map(winner -> winner + ",")
                .collect(Collectors.joining());

        if (winnerString.endsWith(",")) {
            winnerString = winnerString.substring(0, winnerString.length() - 1);
        }
        System.out.println("최종 우승자 : " + winnerString);
    }

    private List<String> computeWinner(Map<String, Integer> mileageForCar) {
        //누가 가장 많이 전진 했는지 우승자를 구한다.
        Integer highestMileage = Collections.max(mileageForCar.values());
        return mileageForCar.entrySet().stream()
                .filter(entry -> entry.getValue().equals(highestMileage))
                .map(Map.Entry::getKey).toList();

    }
}
