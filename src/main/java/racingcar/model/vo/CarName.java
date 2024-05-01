package racingcar.model.vo;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	private CarName(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		this.name = name;
	}

	public static CarName from(final String name) {
		return new CarName(name);
	}

	/**
	 * 자동차의 이름을 구한다.
	 * @return
	 */
	public String fetchCarName() {
		return this.name;
	}
}
