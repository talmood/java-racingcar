package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class Winners {

	private List<Car> cars;

	private Winners(final List<Car> cars) {
		this.cars = cars;
	}

	public static Winners from(final Cars cars) {
		final Position maxPosition = calculateMaxPosition(cars);
		final List<Car> wonCars = cars.getCars().stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.toList();

		return new Winners(wonCars);
	}

	private static Position calculateMaxPosition(final Cars cars) {
		return cars.getCars().stream()
			.map(Car::getPosition)
			.max(Position::compareTo)
			.orElseGet(Position::new);
	}

	public List<Car> getWinners() {
		return List.copyOf(this.cars);
	}
}
