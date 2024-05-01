package racingcar.model.vo;

public class CarName {

	private final String name;

	private CarName(final String name) {
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
