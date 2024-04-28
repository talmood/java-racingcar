package racingcar.model;

import java.util.Objects;

public class RacingCar {

    private static final int MOVE_FORWARD_LOWER_LIMIT = 4;

    private int numOfMovedForward;
    private final String name;

    RacingCar(final int numOfMovedForward, final String name) {
        if (numOfMovedForward < 0) {
            throw new IllegalArgumentException("numOfMovedForward must not be negative");
        }

        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("name must not be null or empty string.");
        }

        this.numOfMovedForward = numOfMovedForward;
        this.name = name;
    }

    public void goForward(final RandomSingleDigitPicker singleDigitPicker) {
        if (singleDigitPicker.pick() >= MOVE_FORWARD_LOWER_LIMIT) {
            this.numOfMovedForward++;
        }
    }

    public int getNumOfMovedForward() {
        return this.numOfMovedForward;
    }

    public String getName() {
        return this.name;
    }

}
