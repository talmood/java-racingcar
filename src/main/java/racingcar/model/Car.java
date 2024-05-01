package racingcar.model;

import racingcar.model.vo.CarName;
import racingcar.model.vo.CarPosition;

public class Car {

	// 자동차 이름
	private final CarName name;
	// 전진 위치
	private final CarPosition position;

	private Car(final CarName name, final CarPosition position) {
		this.name = name;
		this.position = position;
	}

	public static Car of(final String name, final int position) {
		return new Car(CarName.from(name), CarPosition.from(position));
	}

	/**
	 * 자동차의 전진하는 위치를 한 칸 추가한다.
	 */
	public Car increasePosition() {
		return new Car(name, position.increasePosition());
	}

	/**
	 * 자동차의 전진 위치를 구한다.
	 * @return
	 */
	public int fetchCurrentPositionLength() {
		return position.fetchPosition();
	}

	/**
	 * 자동차의 이름을 구한다.
	 * @return
	 */
	public String fetchCarName() {
		return name.fetchCarName();
	}

	/**
	 * 자동차의 현재 전진 상태를 출력한다.
	 */
	public void printState() {
		System.out.println("%s : %s".formatted(name.fetchCarName(), position.printCurrentPosition()));
	}
}
