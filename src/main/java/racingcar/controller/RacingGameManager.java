package racingcar.controller;

import java.util.List;
import racingcar.controller.request.CarNamesRequest;
import racingcar.controller.request.RoundRequest;
import racingcar.controller.response.CarRoundResult;
import racingcar.domain.car.Car;
import racingcar.domain.car.append.CarAppend;
import racingcar.domain.car.append.RandomEngineCarAppend;
import racingcar.domain.game.Cars;
import racingcar.domain.game.RacingGame;
import racingcar.view.OutputView;

public class RacingGameManager {

	private final DriverNumberGenerator driverNumberGenerator;

	public RacingGameManager() {
		this.driverNumberGenerator = new DriverNumberGenerator();
	}

	public void play(final CarNamesRequest carNamesRequest, final RoundRequest roundRequest) {
		final RacingGame racingGame = RacingGame.of(toCarAppends(carNamesRequest), roundRequest.getRound());

		while (!racingGame.isFinished()) {
			racingGame.race();
			OutputView.printRoundResult(toCarRoundResults(racingGame.getCars()));
		}
	}

	private List<CarAppend> toCarAppends(final CarNamesRequest carNamesRequest) {
		return carNamesRequest.getCarNames().stream()
			.map(this::toCarAppend)
			.toList();
	}

	private CarAppend toCarAppend(final String carName) {
		return new RandomEngineCarAppend(driverNumberGenerator.allocate(), carName);
	}

	private List<CarRoundResult> toCarRoundResults(final Cars cars) {
		return cars.getCars().stream()
			.map(this::toCarRoundResult)
			.toList();
	}

	private CarRoundResult toCarRoundResult(final Car car) {
		return CarRoundResult.from(car);
	}
}
