package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.append.CarAppend;

public class RacingGame {

	private final Cars cars;
	private final Round round;

	private RacingGame(final Cars cars, final Round round) {
		this.cars = cars;
		this.round = round;
	}

	public static RacingGame of(final List<CarAppend> carAppends, final int round) {
		final List<Car> cars = toCars(carAppends);
		return new RacingGame(Cars.from(cars), new Round(round));
	}

	private static List<Car> toCars(final List<CarAppend> carAppends) {
		return carAppends.stream()
			.map(CarAppend::toCar)
			.toList();
	}

	public boolean isFinished() {
		return this.round.isFinished();
	}

	public void race() {
		this.round.play();
		this.cars.race();
	}

	public Cars getCars() {
		return Cars.from(this.cars.getCars());
	}
}
