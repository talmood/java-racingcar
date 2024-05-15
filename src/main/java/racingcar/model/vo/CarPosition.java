package racingcar.model.vo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarPosition {
	private static final int MOVE_POSITION_ONCE = 1;
	private static final String MOVE_PROGRESS_BAR = "-";

	private final int position;

	private CarPosition(final int position) {
		this.position = position;
	}

	public static CarPosition from(final int position) {
		return new CarPosition(position);
	}

	public CarPosition increasePosition() {
		return new CarPosition(position + MOVE_POSITION_ONCE);
	}

	public int fetchPosition() {
		return this.position;
	}

	public String printCurrentPosition() {
		return IntStream.range(0, position)
				.mapToObj(i -> MOVE_PROGRESS_BAR)
				.collect(Collectors.joining());
	}
}
