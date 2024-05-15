package racingcar.model;

public class RacingCar {

    private static final int INITIAL_NUM_OF_MOVED_FORWARD = 0;
    private static final int MOVE_FORWARD_LOWER_LIMIT = 4;

    private int numOfMovedForward;
    private final RacingCarName name;

    public RacingCar(final int numOfMovedForward, final RacingCarName name) {
        if (numOfMovedForward < 0) {
            throw new IllegalArgumentException("numOfMovedForward must not be negative");
        }

        this.numOfMovedForward = numOfMovedForward;
        this.name = name;
    }

    public static RacingCar fromName(final RacingCarName name) {
        return new RacingCar(INITIAL_NUM_OF_MOVED_FORWARD, name);
    }

    public void goForward(final RandomSingleDigitPicker singleDigitPicker) {
        if (singleDigitPicker.pick() >= MOVE_FORWARD_LOWER_LIMIT) {
            this.numOfMovedForward++;
        }
    }

    public boolean matchesNumOfMovedForward(final int maxNumOfMovedForward) {
        return this.numOfMovedForward == maxNumOfMovedForward;
    }

    public int getNumOfMovedForward() {
        return this.numOfMovedForward;
    }

    public RacingCarName getName() {
        return this.name;
    }

    public String fetchName() {
        return getName().name();
    }

}
