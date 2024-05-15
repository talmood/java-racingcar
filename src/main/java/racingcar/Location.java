package racingcar;

public class Location {
    private final static String LOCATION_COUNT_STRING = "-";
    private final int location;

    private Location(int location) {
        this.location = location;
    }

    public static Location init() {
        return new Location(0);
    }

    public Location forward() {
        return new Location(this.location + 1);
    }

    public void printLocation() {
        System.out.print(LOCATION_COUNT_STRING.repeat(this.location));
    }

    public int now() {
        return this.location;
    }

    public boolean isSameLocation(int location) {
        return this.location == location;
    }
}
