package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.mock.FakeRandomSingleDigitPicker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("주어진 이름이 null 또는 empty string 일 경우 예외를 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void invalid_car_name(String name) {
        assertThatThrownBy(() -> new RacingCar(0, name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("name must not be null or empty string.");
    }

    @DisplayName("차 객체 생성 시 전진 횟수가 음수라면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -1000})
    void invalid_car_name(int numOfMovedForward) {
        assertThatThrownBy(() -> new RacingCar(numOfMovedForward, "haero77"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("numOfMovedForward must not be negative");
    }

    @DisplayName("랜덤 추출 값이 4 이상일 경우, 앞으로 한 칸 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void goForward_true(int pickedRandomNumber) {
        // given
        final RacingCar sut = new RacingCar(0, "haero77");
        final RandomSingleDigitPicker randomSingleDigitPicker = new FakeRandomSingleDigitPicker(pickedRandomNumber);

        // when
        sut.goForward(randomSingleDigitPicker);

        // then
    	assertThat(sut.getNumOfMovedForward()).isEqualTo(1);
    }

    @DisplayName("랜덤 추출 값이 4 미만일 경우, 앞으로 한 칸 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void goForward_false(int pickedRandomNumber) {
        // given
        final RacingCar sut = new RacingCar(0, "haero77");
        final RandomSingleDigitPicker randomSingleDigitPicker = new FakeRandomSingleDigitPicker(pickedRandomNumber);

        // when
        sut.goForward(randomSingleDigitPicker);

        // then
        assertThat(sut.getNumOfMovedForward()).isEqualTo(0);
    }

}
