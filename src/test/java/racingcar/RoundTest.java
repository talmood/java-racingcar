package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoundTest {

	@Test
	void 라운드를_진행한다() {
		final Round sut = new Round(1);

		sut.play();

		assertThat(sut.getCurrentRound()).isOne();
	}
}
