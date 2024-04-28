package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.request.CarNamesRequest;

public class InputView {

	public static CarNamesRequest inputCarNamesToRace() {
		final String carNames = Console.readLine();
		return CarNamesRequest.from(carNames);
	}

	public static void inputRacingRound() {
		final int round = Integer.parseInt(Console.readLine());
		if (round < 1) {
			throw new IllegalArgumentException("경주 라운드에 0 이하의 값을 입력할 수 없습니다.");
		}
	}
}
