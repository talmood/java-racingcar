package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.FakeRandomSingleDigitPicker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @DisplayName("주어진 횟수 만큼 자동차를 전진시킨다.")
    @Test
    void move_forward() {
        // given
        final RacingCar car1 = new RacingCar(0, new RacingCarName("car1"));
        final RacingCar car2 = new RacingCar(30, new RacingCarName("car2"));
        final RacingCars sut = new RacingCars(List.of(car1, car2));

        final RandomSingleDigitPicker singleDigitPicker = new FakeRandomSingleDigitPicker(4);
        final AttemptCount attemptCount = new AttemptCount(3);

        // when
        sut.moveForward(singleDigitPicker, attemptCount);

        // then
        assertAll(
                () -> assertThat(attemptCount.getCount()).isEqualTo(0),
                () -> assertThat(car1.getNumOfMovedForward()).isEqualTo(3),
                () -> assertThat(car2.getNumOfMovedForward()).isEqualTo(33)
        );
    }

    @DisplayName("가장 많이 이동한 횟수를 가진 자동차가 우승 자동차이다.")
    @Test
    void WinnerCars() {
        // given
        final RacingCar car1 = new RacingCar(0, new RacingCarName("car1"));
        final RacingCar car2 = new RacingCar(30, new RacingCarName("car2"));
        final RacingCar car3 = new RacingCar(30, new RacingCarName("car3"));

        final RacingCars sut = new RacingCars(List.of(car1, car2, car3));

        // when
        WinnerCars actual = sut.judgeWinnerCars();

        // then
        assertThat(actual.getCars()).hasSize(2)
                .extracting("name.name", "numOfMovedForward")
                .containsExactlyInAnyOrder(
                        tuple("car2", 30),
                        tuple("car3", 30)
                );
    }

}