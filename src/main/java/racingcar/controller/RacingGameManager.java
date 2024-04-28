package racingcar.controller;

import static racingcar.view.InputView.inputCarNamesToRace;
import static racingcar.view.InputView.inputRacingRound;

import java.util.List;
import racingcar.controller.request.CarNamesRequest;
import racingcar.controller.request.RoundRequest;
import racingcar.domain.car.append.CarAppend;
import racingcar.domain.car.append.RandomEngineCarAppend;
import racingcar.domain.game.RacingGame;

public class RacingGameManager {

	private final DriverNumberGenerator driverNumberGenerator;

	public RacingGameManager() {
		this.driverNumberGenerator = new DriverNumberGenerator();
	}

	public RacingGame prepareRacingGame() {
		final CarNamesRequest carNamesRequest = inputCarNamesToRace();
		final RoundRequest roundRequest = inputRacingRound();

		return RacingGame.of(toCarAppends(carNamesRequest), roundRequest.getRound());
	}

	private List<CarAppend> toCarAppends(final CarNamesRequest carNamesRequest) {
		return carNamesRequest.getCarNames().stream()
			.map(this::toCarAppend)
			.toList();
	}

	private CarAppend toCarAppend(final String carName) {
		return new RandomEngineCarAppend(driverNumberGenerator.allocate(), carName);
	}
}
