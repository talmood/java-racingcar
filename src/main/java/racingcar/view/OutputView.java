package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.controller.response.CarRoundResult;
import racingcar.controller.response.RacingResult;

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

	public static void printRacingResult(final List<RacingResult> racingResults) {
		final String winnerNames = racingResults.stream()
			.map(RacingResult::getName)
			.collect(Collectors.joining(", "));
		System.out.printf("\n최종 우승자 : %s", winnerNames);
	}

	private static String toPositionView(final int position) {
		return IntStream.range(0, position)
			.mapToObj(number -> POSITION_VIEW)
			.collect(Collectors.joining());
	}
}
