package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoundTest {

	@Test
	void 라운드를_진행한다() {
		final Round sut = new Round(1);

		sut.play();

		assertThat(sut.getCurrentRound()).isOne();
	}

	@Test
	void 라운드가_남지_않은_경우_종료한다() {
		final Round sut = new Round(1);

		sut.play();

		assertThat(sut.isFinished()).isTrue();
	}

	@Test
	void 라운드가_남은_경우_종료하지_않는다() {
		final Round sut = new Round(1);

		assertThat(sut.isFinished()).isFalse();
	}
}
