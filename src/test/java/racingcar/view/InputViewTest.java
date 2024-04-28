package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.InputTest;
import racingcar.controller.request.CarNamesRequest;

@DisplayName("입력 테스트")
public class InputViewTest extends InputTest {

	@DisplayName("자동차 이름 입력 시 ")
	@Nested
	class CarNameInputTest {

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

			final CarNamesRequest actual = InputView.inputCarNamesToRace();

			assertAll(
				() -> assertThat(actual.getCarNames().size()).isEqualTo(2),
				() -> assertThat(actual.getCarNames()).containsExactly("짱구카", "흰둥카")
			);
		}
	}

	@DisplayName("경주 라운드 입력 시 ")
	@Nested
	class RoundInput {

		@ValueSource(strings = {"-1", "0"})
		@ParameterizedTest
		void 라운드_입력_시_0_이하의_값을_입력할_수_없다(final String round) {
			given(round);

			assertThatThrownBy(InputView::inputRacingRound)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("경주 라운드에 0 이하의 값을 입력할 수 없습니다.");
		}
	}
}
