package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.Collections;
import java.util.stream.Collectors;

public class ResultViewFormatter {

    private static final String EMPTY_LINE = System.lineSeparator();
    private static final String BLANK = " ";
    private static final String SEMI_COLON = ":";
    private static final String HYPHEN = "-";

    private final RacingCars cars;

    public ResultViewFormatter(final RacingCars cars) {
        this.cars = cars;
    }

    public String formatGameStatus() {
        return this.cars.getCars().stream()
                .map(this::formatSingleCarStatus)
                .collect(Collectors.joining(EMPTY_LINE));
    }

    private String formatSingleCarStatus(final RacingCar car) {
        return new StringBuilder()
                .append(car.fetchName())
                .append(BLANK)
                .append(SEMI_COLON)
                .append(BLANK)
                .append(String.join("", Collections.nCopies(car.getNumOfMovedForward(), HYPHEN)))
                .toString();
    }

}
