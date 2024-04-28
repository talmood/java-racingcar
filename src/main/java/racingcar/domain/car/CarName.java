package racingcar.domain.car;

import java.util.Objects;

public class CarName {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;

    private final String name;

    private CarName(final String name) {
        this.name = name;
    }

    public static CarName from(final String name) {
        validate(name);
        return new CarName(name);
    }

    private static void validate(final String name) {
        if (name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
