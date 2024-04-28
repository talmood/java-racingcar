package racingcar.domain.car.position;

public class Position {

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
}
