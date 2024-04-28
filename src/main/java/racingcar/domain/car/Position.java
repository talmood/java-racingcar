package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

	private static final int INITIAL_POSITION = 0;

	private int position;

	private Position(final int position) {
		this.position = position;
	}

	public static Position init() {
		return Position.from(INITIAL_POSITION);
	}

	public static Position from(final int position) {
		validate(position);
		return new Position(position);
	}

	private static void validate(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("위치는 마이너스가 될 수 없습니다.");
		}
	}

	public void forward() {
		this.position++;
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Position position1 = (Position) o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public int compareTo(final Position o) {
		return Integer.compare(this.position, o.position);
	}
}
