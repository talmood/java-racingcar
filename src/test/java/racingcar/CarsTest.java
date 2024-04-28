package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
			arguments(List.of(Car.of(1, mock(Engine.class))))
		);
	}
}
