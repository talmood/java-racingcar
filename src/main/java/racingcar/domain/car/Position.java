package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

	private static final int INITIAL_POSITION = 0;

	private int position;

	public Position() {
		this(INITIAL_POSITION);
	}

	public Position(final int position) {
		this.position = position;
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
