package racingcar.domain.car;

import racingcar.domain.car.engine.Engine;
import racingcar.domain.car.position.Position;

public class Car {

	private final Engine engine;
	private final Position position;

	public Car(final Engine engine) {
		this.engine = engine;
		this.position = new Position();
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
