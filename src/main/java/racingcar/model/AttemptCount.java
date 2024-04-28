package racingcar.model;

public class AttemptCount {

    private static final int MIN_COUNT = 1;

    private int count;

    AttemptCount(final int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("Attempt count must be greater than or equal to %d".formatted(MIN_COUNT));
        }
        return new AttemptCount(count);
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
