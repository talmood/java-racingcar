package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.WinnerCars;

import java.util.Collections;
import java.util.stream.Collectors;

public class ResultViewFormatter {

    private static final String EMPTY_LINE = System.lineSeparator();
    private static final String BLANK = " ";
    private static final String SEMI_COLON = ":";
    private static final String HYPHEN = "-";

    private ResultViewFormatter() {
    }

    public static String formatGameStatus(RacingCars cars) {
        return cars.getCars().stream()
                .map(ResultViewFormatter::formatSingleCarStatus)
                .collect(Collectors.joining(EMPTY_LINE));
    }

    private static String formatSingleCarStatus(final RacingCar car) {
        return new StringBuilder()
                .append(car.fetchName())
                .append(BLANK)
                .append(SEMI_COLON)
                .append(BLANK)
                .append(String.join("", Collections.nCopies(car.getNumOfMovedForward(), HYPHEN)))
                .toString();
    }

    public static String formatWinnerCars(final WinnerCars cars) {
        return new StringBuilder()
                .append("최종 우승자")
                .append(BLANK)
                .append(SEMI_COLON)
                .append(BLANK)
                .append(cars.getCars().stream()
                        .map(RacingCar::fetchName)
                        .collect(Collectors.joining(", ")))
                .toString();
    }

}
