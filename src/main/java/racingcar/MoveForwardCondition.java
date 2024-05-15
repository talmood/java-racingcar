package racingcar;

@FunctionalInterface
public interface MoveForwardCondition {

    boolean isForwardAllowed(int value);
}
