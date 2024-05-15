package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.service.RacingCarGame;
import racingcar.view.InputView;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;

public class GameExecutor {
	private static final int DEFAULT_POSITION = 0;

	public static void runGame() {
		final RacingCarGame racingCarGame = new RacingCarGame();
		final InputView inputView = InputView.inputConsole();
		final Iterator<String> carNameIterator = inputView.getCarNameInput().generateCarNameIterator();
		final int gameRound = inputView.getGameRoundInput().getGameRound();

		while (carNameIterator.hasNext()) {
			racingCarGame.addRacingCar(Car.of(carNameIterator.next(), DEFAULT_POSITION));
		}

		IntStream.range(0, gameRound).forEach(i -> racingCarGame.movingOrStopCar());

		racingCarGame.printWinner();
	}
}
