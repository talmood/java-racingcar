package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.engine.FakeForwardEngine;
import racingcar.domain.car.engine.FakeStopEngine;

class WinnersTest {

	@Test
	void 위치를_기준으로_최종_우승자를_선택한다() {
		final Car winner1 = Car.of(1, "짱구카", new FakeForwardEngine());
		final Car loser = Car.of(1, "치타카", new FakeStopEngine());
		final Car winner2 = Car.of(1, "흰둥카", new FakeForwardEngine());
		final Cars cars = Cars.from(List.of(winner1, loser, winner2));
		winner1.move();
		loser.move();
		winner2.move();

		final Winners sut = Winners.from(cars);

		assertAll(
			() -> assertThat(sut.getWinners().size()).isEqualTo(2),
			() -> assertThat(sut.getWinners())
				.containsExactly(winner1, winner2)
		);
	}
}
