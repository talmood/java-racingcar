package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerCarsTest {

    @DisplayName("우승 자동차들의 전진 횟수가 다를 경우 예외를 발생한다.")
    @Test
    void winner_cars_policy() {
        final List<RacingCar> winnerCars = List.of(
                new RacingCar(2, new RacingCarName("pobi")),
                new RacingCar(1, new RacingCarName("woni")),
                new RacingCar(2, new RacingCarName("jun"))
        );
        assertThatThrownBy(() -> new WinnerCars(winnerCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("All number of moved forward of winner cars must be same.");
    }

}