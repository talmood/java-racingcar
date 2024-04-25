package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputView {

	public static String inputCarNamesToRace() {
		final String carNames = Console.readLine();
		if (Objects.isNull(carNames) || carNames.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름에 빈 값을 입력할 수 없습니다.");
		}
		if (carNames.isBlank()) {
			throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
		}
		return carNames;
	}
}
