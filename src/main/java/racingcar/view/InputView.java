package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import racingcar.controller.request.CarNamesRequest;

public class InputView {

	public static CarNamesRequest inputCarNamesToRace() {
		final String carNames = Console.readLine();
		return CarNamesRequest.from(carNames);
	}

	public static void inputRacingRound() {
		final String s = Console.readLine();
		if (Objects.isNull(s) || s.isBlank()) {
			throw new IllegalArgumentException("경주 라운드에 빈 값을 입력할 수 없습니다.");
		}
		final int round = Integer.parseInt(s);
		if (round < 1) {
			throw new IllegalArgumentException("경주 라운드에 0 이하의 값을 입력할 수 없습니다.");
		}
	}
}
