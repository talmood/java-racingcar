package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.request.CarNameInputRequest;
import racingcar.controller.request.GameRoundInputRequest;

public class InputView {
	private final CarNameInputRequest carNameInputRequest;
	private final GameRoundInputRequest gameRoundInputRequest;

	private InputView(final CarNameInputRequest carNameInputRequest, final GameRoundInputRequest gameRoundInputRequest) {
		this.carNameInputRequest = carNameInputRequest;
		this.gameRoundInputRequest = gameRoundInputRequest;
	}

	public static InputView inputConsole() {
		System.out.println("경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		CarNameInputRequest carNameInputRequest = CarNameInputRequest.from(Console.readLine());

		System.out.println("시도할 회수를 입력하세요.");
		GameRoundInputRequest gameRoundInputRequest = GameRoundInputRequest.from(Console.readLine());

		return new InputView(carNameInputRequest, gameRoundInputRequest);
	}

	public CarNameInputRequest getCarNameInput() {
		return this.carNameInputRequest;
	}

	public GameRoundInputRequest getGameRoundInput() {
		return this.gameRoundInputRequest;
	}
}
