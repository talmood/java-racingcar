package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.engine.Engine;

public class CarsTest {

	@MethodSource("provideCar")
	@ParameterizedTest
	void 경주에_참가하는_자동차의_수는_최소_두_대_이상이어야_한다(final List<Car> cars) {
		assertThatThrownBy(() -> Cars.from(cars))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
	}

	private static Stream<Arguments> provideCar() {
		return Stream.of(
			arguments(List.of()),
			arguments(List.of(Car.of(1, "짱구카", mock(Engine.class))))
		);
	}

	@ValueSource(ints = {2, 3, 4, 5})
	@ParameterizedTest
	void 참가한_자동차들을_경주시킨다(final int expected) {
		final Car car = mock(Car.class);
		final Cars sut = Cars.from(createCars(car, expected));

		sut.race();

		verify(car, times(expected)).move();
	}

	private List<Car> createCars(final Car car, final int numberOfCars) {
		final List<Car> cars = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			cars.add(car);
		}
		return cars;
	}
}
