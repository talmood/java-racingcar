package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.request.CarNamesRequest;

public class InputView {

	public static CarNamesRequest inputCarNamesToRace() {
		final String carNames = Console.readLine();
		return CarNamesRequest.from(carNames);
	}
}
