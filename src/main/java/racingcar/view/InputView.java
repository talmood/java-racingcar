package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.request.CarNamesRequest;
import racingcar.controller.request.RoundRequest;

public class InputView {

	public static CarNamesRequest inputCarNamesToRace() {
		final String carNames = Console.readLine();
		return CarNamesRequest.from(carNames);
	}

	public static RoundRequest inputRacingRound() {
		final String round = Console.readLine();
		return RoundRequest.from(round);
	}
}
