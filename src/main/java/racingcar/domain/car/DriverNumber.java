package racingcar.domain.car;

public class DriverNumber {

	private final int driverNumber;

	private DriverNumber(final int driverNumber) {
		this.driverNumber = driverNumber;
	}

	public static DriverNumber from(final int driverNumber) {
		validate(driverNumber);
		return new DriverNumber(driverNumber);
	}

	private static void validate(final int driverNumber) {
		if (driverNumber < 1) {
			throw new IllegalArgumentException("드라이버 넘버는 1 이상의 숫자만 선택할 수 있습니다.");
		}
	}

	public int getDriverNumber() {
		return driverNumber;
	}
}
