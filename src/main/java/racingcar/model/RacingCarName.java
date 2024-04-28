package racingcar.model;

import racingcar.utils.StringUtils;

public record RacingCarName(
        String name
) {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public RacingCarName {
        validateNameCriteria(name);
    }

    private void validateNameCriteria(final String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("name must not be null or empty string.");
        }

        if (!meetsNameLengthCriteria(name)) {
            throw new IllegalArgumentException("name length must be greater than or equal to 0 and less than or equal to 5.");
        }
    }

    private boolean meetsNameLengthCriteria(final String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

}
