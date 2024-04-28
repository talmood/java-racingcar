package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountTest {

    @DisplayName("시도 횟수 초기값은 최소 1 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void invalid_attempt_count(int count) {
        assertThatThrownBy(() -> AttemptCount.from(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Attempt count must be greater than or equal to 1");
    }

    @DisplayName("횟수를 1회 차감할 수 있다.")
    @Test
    void deductOneCount() {
        // given
        final AttemptCount sut = new AttemptCount(1);

        // when
        sut.deductOneCount();

        // then
        assertThat(sut.getCount()).isEqualTo(0);
    }

    @Test
    void ranOutOfCount_true() {
        final AttemptCount sut = new AttemptCount(0);
        assertThat(sut.ranOutOfCount()).isTrue();
    }

    @Test
    void ranOutOfCount_false() {
        final AttemptCount sut = new AttemptCount(1);
        assertThat(sut.ranOutOfCount()).isFalse();
    }

}