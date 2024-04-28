package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DriverNumberTest {

	@ValueSource(ints = {-1, 0})
	@ParameterizedTest
	void 드라이버_번호는_0_이하가_될_수_없다(final int driverNumber) {
		assertThatThrownBy(() -> DriverNumber.from(driverNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("드라이버 넘버는 1 이상의 숫자만 선택할 수 있습니다.");
	}
}
