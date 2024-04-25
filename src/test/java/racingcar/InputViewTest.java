package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest extends InputTest {

	@ValueSource(strings = {",,짱구카", "짱구카,,흰둥카"})
	@ParameterizedTest
	void 자동차_이름_입력_시_빈_값을_입력할_수_없다(final String carNames) {
		given(carNames);

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름에 빈 값을 입력할 수 없습니다.");
	}

	@ValueSource(strings = {" , ", "   ,   ", "짱구카, ,흰둥카"})
	@ParameterizedTest
	void 자동차_이름_입력_시_공백으로만_이름을_만들_수_없다(final String carNames) {
		given(carNames);

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름에 공백을 입력할 수 없습니다.");
	}

	@ValueSource(strings = {"짱구카", ",,,"})
	@ParameterizedTest
	void 한_대의_자동차_이름만_입력할_수_없다(final String carNames) {
		given(carNames);

		assertThatThrownBy(InputView::inputCarNamesToRace)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("경주에 참가할 자동차는 두 대 이상이어야 합니다.");
	}

	@Test
	void 정상적인_경우_입력한_자동차_이름_리스트를_반환한다() {
		given("짱구카,흰둥카");

		final List<String> actual = InputView.inputCarNamesToRace();

		assertThat(actual.size()).isEqualTo(2);
	}
}
