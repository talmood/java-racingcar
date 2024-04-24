package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
	private static final int MIN_RANGE_NUMBER = 0;
	private static final int MAX_RANGE_NUMBER = 9;
	private static final int MOVING_FORWARD = 4;

	private List<Car> cars = new ArrayList<>();

	/**
	 * 경주에 참가할 자동차를 등록한다.
	 * @param car
	 */
	public void addRacingCar(final Car car) {
		cars.add(car);
	}

	/**
	 * 랜덤 값을 구한 후, MOVING_FORWARD 값 이상이면 전진시킨다.
	 */
	public void moveOrStop() {
		for (Car car : cars) {
			int random = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
			if (random >= MOVING_FORWARD) {
				car.increasePosition();
			}
		}

		printRacingState();
	}

	/**
	 * 현재 자동차들의 상태를 출력한다.
	 */
	private void printRacingState() {
		for (Car car : cars) {
			car.printState();
		}
		System.out.println();
	}

	/**
	 * 최종 우승 자동차를 출력한다.
	 */
	public void printWinner() {
		int bestPosition = fetchBestPosition();
		List<Car> winners = fetchWinners(bestPosition);

		String winnerNames = winners.stream()
						.map(Car::fetchCarName)
						.collect(Collectors.joining(", "));

		System.out.println("최종 우승자 : %s".formatted(winnerNames));
	}

	/**
	 * 자동차들 중 제일 많이 전진한 길이를 구한다.
	 * @return
	 */
	private int fetchBestPosition() {
		return cars.stream()
				.map(Car::fetchCurrentPositionLength)
				.max(Integer::compareTo)
				.orElseThrow(() -> new IllegalStateException("자동차의 상태가 정상적이지 않습니다."));
	}

	/**
	 * 우승 자동차들을 구한다.
	 * @param bestPosition
	 * @return
	 */
	private List<Car> fetchWinners(final int bestPosition) {
		return cars.stream()
				.filter(car -> car.fetchCurrentPositionLength() == bestPosition)
				.toList();
	}
}
