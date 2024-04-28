package racingcar.controller.response;

import racingcar.domain.car.Car;

public class CarRoundResult {

	private final int driverNumber;
	private final String name;
	private final int position;

	private CarRoundResult(final int driverNumber, final String name, final int position) {
		this.driverNumber = driverNumber;
		this.name = name;
		this.position = position;
	}

	public static CarRoundResult from(final Car car) {
		return new CarRoundResult(car.getDriverNumber().getDriverNumber(), car.getCarName().getName(), car.getPosition().getPosition());
	}

	public int getDriverNumber() {
		return this.driverNumber;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}
}
