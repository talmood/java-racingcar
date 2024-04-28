package racingcar.controller.response;

import racingcar.domain.car.Car;

public class RacingResult {

	private final int driverNumber;
	private final String name;

	private RacingResult(final int driverNumber, final String name) {
		this.driverNumber = driverNumber;
		this.name = name;
	}

	public static RacingResult from(final Car car) {
		return new RacingResult(car.getDriverNumber().getDriverNumber(), car.getCarName().getName());
	}

	public int getDriverNumber() {
		return this.driverNumber;
	}

	public String getName() {
		return this.name;
	}
}
