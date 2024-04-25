package racingcar;

public class CarName {

    private final String name;

    private CarName(final String name) {
        this.name = name;
    }

    public static CarName from(final String name) {
        throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
