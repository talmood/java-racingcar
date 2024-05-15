package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;

public class Cars {

	private static final int MINIMUM_PARTICIPANTS = 2;

	private final List<Car> cars;

	private Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public static Cars from(final List<Car> cars) {
		validate(cars);
		return new Cars(cars);
	}

	private static void validate(final List<Car> cars) {
		if (cars.size() < MINIMUM_PARTICIPANTS) {
			throw new IllegalArgumentException("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
		}
	}

	public void race() {
		this.cars.forEach(Car::move);
	}

	public List<Car> getCars() {
		return List.copyOf(this.cars);
	}
}
