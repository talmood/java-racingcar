package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingGameInitializer {

    public RacingGame initializeGame() {
        final List<Car> cars = inputCarNames();
        final int round = inputRound();
        System.out.println();
        return new RacingGame(new ParticipatingCars(cars), round);
    }

    private List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        final String input = Console.readLine().trim();
        final String[] carNamesArray = input.split(",");
        final List<String> carNames = Arrays.stream(carNamesArray)
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();

        validateCarNames(carNames);
        return createCars(carNames);
    }

    private void validateCarNames(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차가 필요합니다.");
        }
        Set<String> nameSet = new HashSet<>();
        for (final String name : carNames) {
            if (nameSet.contains(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다. : " + name);
            }
            nameSet.add(name);
        }
    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }
    }
}
