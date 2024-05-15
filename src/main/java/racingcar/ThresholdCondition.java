package racingcar;

public class ThresholdCondition implements MoveForwardCondition {

    private final static int MOVE_FORWARD_CONDITION_THRESHOLD = 4;

    @Override
    public boolean isForwardAllowed(int value) {
        return value >= MOVE_FORWARD_CONDITION_THRESHOLD;
    }
}
