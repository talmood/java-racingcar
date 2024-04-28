package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	void 위치를_전진시킨다() {
		final Position sut = new Position();

		sut.forward();

		assertThat(sut.getPosition()).isOne();
	}
}
