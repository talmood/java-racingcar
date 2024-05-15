package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	void 위치는_0_이하가_될_수_없다() {
		assertThatThrownBy(() -> Position.from(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("위치는 마이너스가 될 수 없습니다.");
	}

	@Test
	void 위치를_전진시킨다() {
		final Position sut = Position.init();

		sut.forward();

		assertThat(sut.getPosition()).isOne();
	}
}
