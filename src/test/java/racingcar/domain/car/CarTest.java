package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.engine.Engine;

public class CarTest {

	private final Engine engine = mock(Engine.class);

	@Test
	void 자동차_엔진_이동_조건이_성립하는_경우_이동할_수_있다() {
		when(engine.isMovable()).thenReturn(true);
		final Car sut = Car.of(1, "짱구카", engine);

		sut.move();

		assertAll(
			() -> verify(engine).isMovable(),
			() -> assertThat(sut.getPosition())
				.usingRecursiveComparison()
				.isEqualTo(Position.from(1))
		);
	}

	@Test
	void 자동차_엔진_이동_조건이_성립하지_않는_경우_이동할_수_없다() {
		when(engine.isMovable()).thenReturn(false);
		final Car sut = Car.of(1, "짱구카", engine);

		sut.move();

		assertAll(
			() -> verify(engine).isMovable(),
			() -> assertThat(sut.getPosition())
				.usingRecursiveComparison()
				.isEqualTo(Position.init())
		);
	}

	@CsvSource(value = {
		"0, true",
		"1, false"
	})
	@ParameterizedTest
	void 두_자동차가_같은_위치인지_확인한다(final int maxPosition, final boolean expected) {
		final Car sut = Car.of(1, "짱구카", mock(Engine.class));

		final boolean actual = sut.isSamePosition(Position.from(maxPosition));

		assertThat(actual).isEqualTo(expected);
	}
}
