package racingcar.model;

import java.util.Objects;

public record RacingCarName(
        String name
) {

    private static final int MAX_NAME_LENGTH = 5;

    public RacingCarName {
        validateNameCriteria(name);
    }

    private void validateNameCriteria(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("name must not be null.");
        }

        if (!meetsNameLengthCriteria(name)) {
            throw new IllegalArgumentException("name length must be greater than or equal to 0 and less than or equal to 5.");
        }
    }

    private boolean meetsNameLengthCriteria(final String name) {
        return !name.isBlank() && name.length() <= MAX_NAME_LENGTH;
    }

}
