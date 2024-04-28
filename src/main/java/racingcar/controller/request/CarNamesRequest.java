package racingcar.controller.request;

import java.util.Arrays;
import java.util.List;

public class CarNamesRequest {

	private final List<String> carNames;

	private CarNamesRequest(final List<String> carNames) {
		this.carNames = carNames;
	}

	public static CarNamesRequest from(final String carNames) {
		CarNameInputValidator.validate(carNames);
		return new CarNamesRequest(Arrays.stream(carNames.split(",")).toList());
	}

	public List<String> getCarNames() {
		return List.copyOf(this.carNames);
	}
}
