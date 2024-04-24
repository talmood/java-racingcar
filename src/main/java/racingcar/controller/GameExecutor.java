package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.service.RacingCarGame;

public class GameExecutor {
	public static void runGame() {
		RacingCarGame racingCarGame = new RacingCarGame();
		String carInput = Console.readLine();
		String countInput = Console.readLine();

		// 입력값이 숫자인지 확인
		if (!countInput.matches("[0-9]+")) {
			throw new IllegalArgumentException("두 번째 입력값은 0 또는 양수값이어야 합니다.");
		}

		int gameCount = Integer.parseInt(countInput);

		for (String carInputName : carInput.split(",")) {
			racingCarGame.addRacingCar(Car.from(carInputName));
		}

		for (int i = 0; i < gameCount; i++) {
			racingCarGame.moveOrStop();
		}

		racingCarGame.printWinner();
	}
}
