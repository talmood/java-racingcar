package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("create()")
    void create() {
        RacingCar racingCar = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        int location = racingCar.getNowLocation();

        assertThat(location).isEqualTo(0);
    }

    @Test
    @DisplayName("ThresholdCondition인 경우 임계치 보다 높은 value라면 전진한다.")
    void ThresholdCondition인_경우_임계치_보다_높은_value라면_전진한다() {
        RacingCar racingCar = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        int value = 4;

        RacingCar movedRacingCar = racingCar.moveForwardByValue(value);

        int location = movedRacingCar.getNowLocation();
        int movedLocation = 1;
        assertThat(location).isEqualTo(movedLocation);
    }

    @Test
    @DisplayName("ThresholdCondition인 경우 임계치 보다 낮은 value라면 전진하지 않는다.")
    void ThresholdCondition인_경우_임계치_보다_낮은_value라면_전진하지_않는다() {
        RacingCar racingCar = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        int value = 3;

        RacingCar movedRacingCar = racingCar.moveForwardByValue(value);

        int location = movedRacingCar.getNowLocation();
        int notMovedLocation = 0;
        assertThat(location).isEqualTo(notMovedLocation);
    }
}