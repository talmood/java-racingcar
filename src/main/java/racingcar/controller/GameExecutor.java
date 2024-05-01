package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.service.RacingCarGame;

public class GameExecutor {
	public static void runGame() {
		RacingCarGame racingCarGame = new RacingCarGame();
		System.out.println("경주 할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String carInput = Console.readLine();
		System.out.println("시도할 회수를 입력하세요.");
		String countInput = Console.readLine();

		validCountInput(countInput);

		int gameCount = Integer.parseInt(countInput);

		for (String carInputName : splitCarInput(carInput)) {
			racingCarGame.addRacingCar(Car.from(carInputName));
		}

		for (int i = 0; i < gameCount; i++) {
			racingCarGame.moveOrStop();
		}

		racingCarGame.printWinner();
	}

	private static void validCountInput(String countInput) {
		// 입력값이 숫자인지 확인
		if (!countInput.matches("[0-9]+")) {
			throw new IllegalArgumentException("두 번째 입력값은 0 또는 양수값이어야 합니다.");
		}
	}

	private static String[] splitCarInput(String carInput) {
		try {
			return carInput.split(",");
		} catch (Exception e) {
			throw new IllegalArgumentException("자동차 이름 입력값이 올바르지 않습니다.");
		}
	}
}
