package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

	public static List<String> inputCarNamesToRace() {
		final String carNames = Console.readLine();
		CarNameInputValidator.validate(carNames);
		return Arrays.stream(carNames.split(",")).toList();
	}
}
