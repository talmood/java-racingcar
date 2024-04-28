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

}