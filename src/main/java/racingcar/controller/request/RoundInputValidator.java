package racingcar.controller.request;

import java.util.Objects;

class RoundInputValidator {
	
	private static final int MINIMUM_ROUND = 1;
	
	static void validate(final String round) {
		validateEmptyRound(round);
		validateRoundNumber(round);
	}

	private static void validateEmptyRound(final String round) {
		if (Objects.isNull(round) || round.isBlank()) {
			throw new IllegalArgumentException("경주 라운드에 빈 값을 입력할 수 없습니다.");
		}
	}

	private static void validateRoundNumber(final String round) {
		try {
			validateMinimumRound(round);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("경주 라운드에 정수가 아닌 값을 입력할 수 없습니다.");
		}
	}

	private static void validateMinimumRound(final String round) {
		if (Integer.parseInt(round) < MINIMUM_ROUND) {
			throw new IllegalArgumentException("경주 라운드에 0 이하의 값을 입력할 수 없습니다.");
		}
	}
}
