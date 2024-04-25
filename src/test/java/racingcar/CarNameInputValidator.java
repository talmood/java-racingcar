package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarNameInputValidator {

	private static final String CAR_NAME_SEPARATOR = ",";

	public static void validate(final String carNames) {
		validateNumberOfCars(carNames);
		validateEmptyCarNames(splitCarNames(carNames));
		validateBlankCarNames(splitCarNames(carNames));
	}

	private static void validateNumberOfCars(final String carNames) {
		final int numberOfCars = carNames.split(CAR_NAME_SEPARATOR).length;
		if (numberOfCars < 2) {
			throw new IllegalArgumentException("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
		}
	}

	private static void validateEmptyCarNames(final List<String> carNames) {
		carNames.forEach(CarNameInputValidator::validateEmptyCarName);
	}

	private static void validateEmptyCarName(final String carName) {
		if (Objects.isNull(carName) || carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름에 빈 값을 입력할 수 없습니다.");
		}
	}

	private static void validateBlankCarNames(final List<String> carNames) {
		carNames.forEach(CarNameInputValidator::validateBlankCarName);
	}

	private static void validateBlankCarName(final String carName) {
		if (carName.isBlank()) {
			throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
		}
	}

	private static List<String> splitCarNames(final String carNames) {
		return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR)).toList();
	}
}
