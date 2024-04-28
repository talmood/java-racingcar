package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarName;
import racingcar.model.RacingCars;
import racingcar.model.WinnerCars;

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

    @DisplayName("우승자 출력을 위한 문자열을 포맷팅한다.")
    @Test
    void formatWinnerCars() {
        // given
        final WinnerCars winnerCars = new WinnerCars(
                List.of(
                        new RacingCar(2, new RacingCarName("pobi")),
                        new RacingCar(2, new RacingCarName("jun"))
                )
        );

        // when
        final String actual = ResultViewFormatter.formatWinnerCars(winnerCars);

        // then
        assertThat(actual).isEqualTo("최종 우승자 : pobi, jun");
    }

}