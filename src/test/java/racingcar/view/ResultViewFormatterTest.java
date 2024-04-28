package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarName;
import racingcar.model.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewFormatterTest {

    @DisplayName("게임 현황을 문자열로 포맷팅한다.")
    @Test
    void formatGameStatus() {
        // given
        final RacingCars racingCars = new RacingCars(
                List.of(
                        new RacingCar(2, new RacingCarName("pobi")),
                        new RacingCar(1, new RacingCarName("woni")),
                        new RacingCar(2, new RacingCarName("jun"))
                )
        );

        // when
        final String actual = ResultViewFormatter.formatGameStatus(racingCars);

        // then
        assertThat(actual).isEqualTo(
                """
                        pobi : --
                        woni : -
                        jun : --"""
        );
    }

}