package racingcar.domain.car.append;

import racingcar.domain.RandomNumberPicker;
import racingcar.domain.car.Car;
import racingcar.domain.car.engine.Engine;
import racingcar.domain.car.engine.RandomEngine;

public class RandomEngineCarAppend implements CarAppend {

	private final int driverNumber;
	private final String carName;

	public RandomEngineCarAppend(final int driverNumber, final String carName) {
		this.driverNumber = driverNumber;
		this.carName = carName;
	}

	@Override
	public Car toCar() {
		final Engine engine = new RandomEngine(new RandomNumberPicker());
		return Car.of(this.driverNumber, this.carName, engine);
	}
}
