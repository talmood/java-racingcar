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
		if (carNames.split(",").length == 1) {
			throw new IllegalArgumentException("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
		}
		return carNames;
	}
}
