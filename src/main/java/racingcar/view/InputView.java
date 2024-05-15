package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.request.CarNamesRequest;
import racingcar.controller.request.RoundRequest;

public class InputView {

	public static CarNamesRequest inputCarNamesToRace() {
		printInputMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		final String carNames = Console.readLine();
		return CarNamesRequest.from(carNames);
	}

	public static RoundRequest inputRacingRound() {
		printInputMessage("시도할 회수는 몇회인가요?");
		final String round = Console.readLine();
		return RoundRequest.from(round);
	}

	private static void printInputMessage(final String message) {
		System.out.println(message);
	}
}
