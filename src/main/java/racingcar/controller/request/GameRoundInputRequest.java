package racingcar.controller.request;

import java.util.Objects;

public class GameRoundInputRequest {
	private static final String NUMBER_REGEX = "[0-9]+";
	private final int gameRound;

	private GameRoundInputRequest(final int gameRound) {
		this.gameRound = gameRound;
	}

	public static GameRoundInputRequest from(final String gameRoundInput) {
		validation(gameRoundInput);
		return new GameRoundInputRequest(parsingNumber(gameRoundInput));
	}

	static void validation(final String gameRoundInput) {
		validationNotNull(gameRoundInput);
		validationNumberParsing(gameRoundInput);
	}

	private static void validationNotNull(final String gameRoundInput) {
		if (!Objects.nonNull(gameRoundInput)) {
			throw new IllegalArgumentException("시도할 횟수를 입력해야 합니다.");
		}
	}

	private static void validationNumberParsing(final String gameRoundInput) {
		if (!gameRoundInput.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException("시도할 횟수는 0 또는 양수값이어야 합니다.");
		}
	}

	private static int parsingNumber(final String gameRoundInput) {
		return Integer.parseInt(gameRoundInput);
	}

	public int getGameRound() {
		return this.gameRound;
	}
}
