package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.controller.response.CarRoundResult;

public class OutputView {

	private static final String POSITION_VIEW = "-";

	public static void printRoundResult(final List<CarRoundResult> carRoundResults) {
		System.out.println("\n실행 결과");
		for (final CarRoundResult carRoundResult : carRoundResults) {
			final String name = carRoundResult.getName();
			final String positionView = toPositionView(carRoundResult.getPosition());

			System.out.printf("%s : %s\n", name, positionView);
		}
	}

	private static String toPositionView(final int position) {
		return IntStream.range(0, position)
			.mapToObj(number -> POSITION_VIEW)
			.collect(Collectors.joining());
	}
}
