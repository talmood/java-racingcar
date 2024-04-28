package racingcar.model;

public class AttemptCount {

    private static final int MIN_COUNT = 1;

    private int count;

    public AttemptCount(final int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("Attempt count must be greater than or equal to %d".formatted(MIN_COUNT));
        }
        this.count = count;
    }

    public void deductOneCount() {
        if (this.count - 1 < 0) {
            throw new IllegalStateException("Count cannot be negative.");
        }
        this.count--;
    }

    public int getCount() {
        return count;
    }

}
