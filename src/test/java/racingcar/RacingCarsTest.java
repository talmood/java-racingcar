package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("가장 많이 전진한 차량 하나를 찾는다.")
    void 가장_많이_전진한_차량_하나를_찾는다() {
        RacingCar pobi = RacingCar.create(CarName.create("pobi"), new ThresholdCondition());
        RacingCar jun = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        RacingCar woni = RacingCar.create(CarName.create("woni"), new ThresholdCondition());

        int moveValue = 5;
        jun = jun.moveForwardByValue(moveValue);
        RacingCars racingCars = RacingCars.create(List.of(pobi, jun, woni));
        RacingCar maxLocationCar = racingCars.findMaxLocationCar();

        assertThat(maxLocationCar.getCarName()).isEqualTo("jun");
    }

    @Test
    @DisplayName("같은 위치의 차량을 찾는다.")
    void 같은_위치의_차량을_찾는다() {
        RacingCar pobi = RacingCar.create(CarName.create("pobi"), new ThresholdCondition());
        RacingCar jun = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        RacingCar woni = RacingCar.create(CarName.create("woni"), new ThresholdCondition());

        int moveValue = 5;
        jun = jun.moveForwardByValue(moveValue);
        RacingCars racingCars = RacingCars.create(List.of(pobi, jun, woni));
        RacingCars sameLocationCars = racingCars.findSameLocationCar(pobi);

        assertThat(sameLocationCars.getCarNamesWithJoin(",")).isEqualTo("pobi,woni");
    }

    @Test
    @DisplayName("차량들의 이름을 join한다")
    void 차량들의_이름을_join한다() {
        RacingCar pobi = RacingCar.create(CarName.create("pobi"), new ThresholdCondition());
        RacingCar jun = RacingCar.create(CarName.create("jun"), new ThresholdCondition());
        RacingCar woni = RacingCar.create(CarName.create("woni"), new ThresholdCondition());

        RacingCars racingCars = RacingCars.create(List.of(pobi, jun, woni));
        String delimiter = ",";
        String joinedName = "pobi" + delimiter + "jun" + delimiter + "woni";

        assertThat(racingCars.getCarNamesWithJoin(",")).isEqualTo(joinedName);
    }
}