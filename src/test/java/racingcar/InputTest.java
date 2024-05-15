package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;

public abstract class InputTest {

	protected void given(final String input) {
		final String inputWithNewLine = input + "\n";
		System.setIn(new ByteArrayInputStream(inputWithNewLine.getBytes()));
	}

	@BeforeEach
	void setUp() {
		Console.close();
	}
}
