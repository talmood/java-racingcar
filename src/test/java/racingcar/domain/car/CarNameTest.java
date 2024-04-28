package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름이_5자_이하인_경우_정상적으로_생성한다() {
        assertDoesNotThrow(() -> CarName.from("12345"));
    }

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> CarName.from("123456"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
