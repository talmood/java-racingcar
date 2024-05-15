package racingcar;

import java.util.Objects;

public class RacingCar {

    private static final String NAME_LOCATION_DELIMITER = " : ";
    private final CarName carName;
    private final Location location;
    private final MoveForwardCondition moveForwardCondition;

    private RacingCar(CarName carName, Location location, MoveForwardCondition moveForwardCondition) {
        if (Objects.isNull(carName) || Objects.isNull(location) || Objects.isNull(moveForwardCondition)) {
            throw new IllegalArgumentException("carName, location, moveForwardCondition must be not null");
        }
        this.carName = carName;
        this.location = location;
        this.moveForwardCondition = moveForwardCondition;
    }

    public static RacingCar create(CarName carName, MoveForwardCondition moveForwardCondition) {
        return new RacingCar(carName, Location.init(), moveForwardCondition);
    }

    public RacingCar moveForwardByValue(int value) {
        if (this.moveForwardCondition.isForwardAllowed(value)) {
            return new RacingCar(this.carName, this.location.forward(), this.moveForwardCondition);
        }

        return this;
    }

    public void printRacingCar() {
        this.carName.printName();
        System.out.print(NAME_LOCATION_DELIMITER);
        this.location.printLocation();
        System.out.println();
    }

    public int getNowLocation() {
        return this.location.now();
    }

    public boolean isSameLocation(RacingCar racingCar) {
        return this.location.isSameLocation(racingCar.getNowLocation());
    }

    public String getCarName() {
        return this.carName.getCarName();
    }
}
