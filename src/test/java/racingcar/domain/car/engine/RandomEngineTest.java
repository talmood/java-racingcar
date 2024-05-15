package racingcar.domain.car.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RandomNumberPicker;

public class RandomEngineTest {

	private final RandomNumberPicker randomNumberPicker = mock(RandomNumberPicker.class);

	@ValueSource(ints = {0, 1, 2, 3})
	@ParameterizedTest
	void 난수가_3_이하인_경우_이동_불가능하다(final int randomNumber) {
		when(randomNumberPicker.pick()).thenReturn(randomNumber);
		final Engine sut = new RandomEngine(randomNumberPicker);

		final boolean actual = sut.isMovable();

		assertAll(
			() -> verify(randomNumberPicker).pick(),
			() -> assertThat(actual).isFalse()
		);
	}

	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@ParameterizedTest
	void 난수가_4_이상인_경우_이동_불가능하다(final int randomNumber) {
		when(randomNumberPicker.pick()).thenReturn(randomNumber);
		final Engine sut = new RandomEngine(randomNumberPicker);

		final boolean actual = sut.isMovable();

		assertAll(
			() -> verify(randomNumberPicker).pick(),
			() -> assertThat(actual).isTrue()
		);
	}
}
