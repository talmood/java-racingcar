package racingcar.domain.car.engine;

import racingcar.domain.RandomNumberPicker;

public class RandomEngine implements Engine {

	private static final int MOVABLE_CONDITION = 3;

	private final RandomNumberPicker randomNumberPicker;

	public RandomEngine(final RandomNumberPicker randomNumberPicker) {
		this.randomNumberPicker = randomNumberPicker;
	}

	@Override
	public boolean isMovable() {
		final int randomNumber = randomNumberPicker.pick();
		return randomNumber > MOVABLE_CONDITION;
	}
}
