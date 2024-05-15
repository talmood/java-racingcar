package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.mock.FakeInputReader;
import racingcar.mock.FakeOutputPrinter;
import racingcar.model.AttemptCount;
import racingcar.model.RacingCarNames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("자동차 이름을 입력받는다.")
    @Test
    void input_car_names() {
        // given
        final InputReader inputReader = new FakeInputReader("pobi,woni,jun");
        final OutputPrinter outputPrinter = new FakeOutputPrinter();
        final InputView sut = new InputView(inputReader, outputPrinter);

        // when
        final RacingCarNames actual = sut.inputCarNames();

        // then
        assertThat(actual.names())
                .hasSize(3)
                .extracting("name")
                .containsExactlyInAnyOrder(
                        "pobi",
                        "woni",
                        "jun"
                );
    }

    @DisplayName("자동차 이름 입력 시, 문자열 리터럴에 ','외의 기호가 포함되어 있으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"_,,,_", "p!@#!@#obo"})
    void fromNameLiterals_invalid_literal(String carNameLiteral) {
        final InputReader inputReader = new FakeInputReader(carNameLiteral);
        final OutputPrinter outputPrinter = new FakeOutputPrinter();
        final InputView sut = new InputView(inputReader, outputPrinter);

        assertThatThrownBy(sut::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Literal of RacingCarNames must not contain special character except ','");
    }

    @DisplayName("자동차 이름 생성 시, 한 개 미만의 이름을 입력 받으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",", ",,"})
    void fromNameLiterals_invalid_name_size(String carNameLiteral) {
        final InputReader inputReader = new FakeInputReader(carNameLiteral);
        final OutputPrinter outputPrinter = new FakeOutputPrinter();
        final InputView sut = new InputView(inputReader, outputPrinter);

        assertThatThrownBy(sut::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Literal of RacingCarNames must contain at least one name.");
    }

    @DisplayName("시도할 횟수를 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "100", "30000"})
    void input_attempt_count(String attemptCountLiteral) {
        // given
        final InputReader inputReader = new FakeInputReader(attemptCountLiteral);
        final OutputPrinter outputPrinter = new FakeOutputPrinter();
        final InputView sut = new InputView(inputReader, outputPrinter);

        // when
        AttemptCount actual = sut.inputAttemptCount();

        // then
    	Assertions.assertThat(actual.getCount()).isEqualTo(Integer.parseInt(attemptCountLiteral));
    }

    @DisplayName("시도할 횟수를 입력 시 유효하지 않은 값을 입력하면 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abc", "--123312_21312", ","})
    void input_attempt_count_invalid_value(String attemptCountLiteral) {
        final InputReader inputReader = new FakeInputReader(attemptCountLiteral);
        final OutputPrinter outputPrinter = new FakeOutputPrinter();
        final InputView sut = new InputView(inputReader, outputPrinter);

        assertThatThrownBy(sut::inputAttemptCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

}