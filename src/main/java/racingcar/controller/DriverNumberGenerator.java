package racingcar.controller;

public class DriverNumberGenerator {

	private int driverNumber;

	public DriverNumberGenerator() {
		this.driverNumber = 0;
	}

	public int allocate() {
		return ++this.driverNumber;
	}
}
