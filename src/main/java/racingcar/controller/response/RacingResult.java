package racingcar.controller.response;

import racingcar.domain.car.Car;

public class RacingResult {

	private final int driverNumber;
	private final String name;
	private final boolean isActivateDriverNumber;

	private RacingResult(final int driverNumber, final String name, final boolean isActivateDriverNumber) {
		this.driverNumber = driverNumber;
		this.name = name;
		this.isActivateDriverNumber = isActivateDriverNumber;
	}

	public static RacingResult of(final Car car, final boolean isActivateDriverNumber) {
		return new RacingResult(car.getDriverNumber().getDriverNumber(), car.getCarName().getName(), isActivateDriverNumber);
	}

	public int getDriverNumber() {
		return this.driverNumber;
	}

	public String getName() {
		return this.name;
	}

	public boolean isActivateDriverNumber() {
		return this.isActivateDriverNumber;
	}
}
