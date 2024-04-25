package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest extends InputTest {

	@EmptySource
	@ParameterizedTest
	void 자동차_이름_입력_시_빈_값을_입력할_수_없다(final String carNames) {
		given(carNames);

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름에 빈 값을 입력할 수 없습니다.");
	}

	@ValueSource(strings = {" ", "   "})
	@ParameterizedTest
	void 자동차_이름_입력_시_공백으로만_이름을_만들_수_없다(final String carNames) {
		given(carNames);

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름에 공백을 입력할 수 없습니다.");
	}

	@Test
	void 한_대의_자동차_이름만_입력할_수_없다() {
		given("짱구카");

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
	}
}
