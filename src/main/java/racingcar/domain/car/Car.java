package racingcar.domain.car;

import racingcar.domain.car.engine.Engine;
import racingcar.domain.car.position.Position;

public class Car {

	private final DriverNumber driverNumber;
	private final Engine engine;
	private final Position position;

	private Car(final DriverNumber driverNumber, final Engine engine, final Position position) {
		this.driverNumber = driverNumber;
		this.engine = engine;
		this.position = position;
	}

	public static Car of(final int driverNumber, final Engine engine) {
		return new Car(DriverNumber.from(driverNumber), engine, new Position());
	}

	public void move() {
		if (this.engine.isMovable()) {
			this.position.forward();
		}
	}

	public Position getPosition() {
		return new Position(this.position.getPosition());
	}
}
