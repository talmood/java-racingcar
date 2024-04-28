package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    @DisplayName("Location은 항상 0으로 초기화되어야 한다.")
    void Location은_항상_0으로_초기화되어야_한다() {
        Location location = Location.init();

        int initLocationValue = 0;
        Assertions.assertThat(location.now()).isEqualTo(initLocationValue);
    }

    @Test
    @DisplayName("forward() 호출 시 전진해야 한다.")
    void forward_호출_시_전진해야_한다() {
        Location location = Location.init();

        Location movedLocation = location.forward();

        int movedLocationValue = 1;
        Assertions.assertThat(movedLocation.now()).isEqualTo(movedLocationValue);
    }

}