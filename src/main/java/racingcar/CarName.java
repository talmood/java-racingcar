package racingcar;

import org.junit.platform.commons.util.StringUtils;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String carName;

    private CarName(String carName) {
        if (this.isNotValidName(carName)) {
            throw new IllegalArgumentException(String.format("car name cannot exceed %d characters", MAX_NAME_LENGTH));
        }

        this.carName = carName;
    }

    public static CarName create(String name) {
        return new CarName(name);
    }

    private boolean isNotValidName(String name) {
        return StringUtils.isBlank(name) || this.isExceedNameSize(name);
    }

    private boolean isExceedNameSize(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public void printName() {
        System.out.print(this.carName);
    }

    public String getCarName() {
        return this.carName;
    }
}
