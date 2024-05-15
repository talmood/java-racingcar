package racingcar.controller.request;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CarNameInputRequest {
	private static final String SPLIT_DELIMITER = ",";
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MIN_CAR_NAME_COUNT = 2;

	private final List<String> carNames;

	private CarNameInputRequest(final List<String> carNames) {
		this.carNames = carNames;
	}

	public static CarNameInputRequest from(final String carNameInput) {
		validation(carNameInput);
		return new CarNameInputRequest(splitCarInput(carNameInput));
	}

	static void validation(final String carNameInput) {
		validationNotNull(carNameInput);
		validationCanSplit(carNameInput);
		validationCarNameLength(carNameInput);
		validationCarCount(carNameInput);
	}

	private static void validationNotNull(final String carNameInput) {
		if (!Objects.nonNull(carNameInput)) {
			throw new IllegalArgumentException("자동차 입력값을 입력해야 합니다.");
		}
	}

	private static void validationCanSplit(final String carNameInput) {
		try {
			carNameInput.split(SPLIT_DELIMITER);
		} catch (Exception e) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분할 수 있게 입력해주세요.");
		}
	}

	private static void validationCarNameLength(final String carNameInput) {
		String[] splitCarNames = carNameInput.split(SPLIT_DELIMITER);
		for (String carName : splitCarNames) {
			if (carName.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
			}
		}
	}

	private static void validationCarCount(final String carNameInput) {
		String[] splitCarNames = carNameInput.split(SPLIT_DELIMITER);
		if (splitCarNames.length < MIN_CAR_NAME_COUNT) {
			throw new IllegalArgumentException("레이싱 경주에 참여하는 자동차는 최소 2개여야 합니다.");
		}
	}

	private static List<String> splitCarInput(final String carNameInput) {
		String[] splitCarNames = carNameInput.split(SPLIT_DELIMITER);
		return Arrays.stream(splitCarNames).toList();
	}

	public Iterator<String> generateCarNameIterator() {
		return this.carNames.iterator();
	}
}
