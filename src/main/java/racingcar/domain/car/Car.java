package racingcar.domain.car;

import racingcar.domain.car.engine.Engine;

public class Car {

	private final DriverNumber driverNumber;
	private final CarName carName;
	private final Engine engine;
	private final Position position;

	private Car(final DriverNumber driverNumber, final CarName carName, final Engine engine, final Position position) {
		this.driverNumber = driverNumber;
		this.carName = carName;
		this.engine = engine;
		this.position = position;
	}

	public static Car of(final int driverNumber, final String carName, final Engine engine) {
		return new Car(DriverNumber.from(driverNumber), CarName.from(carName), engine, new Position());
	}

	public void move() {
		if (this.engine.isMovable()) {
			this.position.forward();
		}
	}

	public boolean isSamePosition(final Position position) {
		return this.position.equals(position);
	}

	public DriverNumber getDriverNumber() {
		return DriverNumber.from(this.driverNumber.getDriverNumber());
	}

	public CarName getCarName() {
		return CarName.from(this.carName.getName());
	}

	public Position getPosition() {
		return new Position(this.position.getPosition());
	}
}
