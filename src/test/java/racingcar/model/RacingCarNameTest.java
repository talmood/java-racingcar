package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarNameTest {

    @DisplayName("자동차 이름은 1글자 미만 일 수 없고, 5글자를 초과할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = "123456")
    void RacingCarName(String name) {
        assertThatThrownBy(() -> new RacingCarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 이름이 null 또는 empty string 일 경우 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void invalid_car_name(String name) {
        assertThatThrownBy(() -> new RacingCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name must not be null or empty string.");
    }

}