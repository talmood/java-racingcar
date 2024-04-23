package racingcar.model;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;

	// 자동차 이름
	private String name;
	// 전진 위치
	private String position = "";

	private Car(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		this.name = name;
	}

	public static Car from(final String name) {
		return new Car(name);
	}

	/**
	 * 자동차의 전진하는 위치를 한 칸 추가한다.
	 */
	public void increasePosition() {
		this.position += "-";
	}

	/**
	 * 자동차의 전진 위치를 구한다.
	 * @return
	 */
	public int fetchCurrentPositionLength() {
		return position.length();
	}

	/**
	 * 자동차의 이름을 구한다.
	 * @return
	 */
	public String fetchCarName() {
		return name;
	}

	/**
	 * 자동차의 현재 전진 상태를 출력한다.
	 */
	public void printState() {
		System.out.println("%s : %s".formatted(name, position));
	}
}
