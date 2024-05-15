package racingcar.utils;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean hasText(String target) {
        return Objects.nonNull(target) && !target.isEmpty();
    }

    public static boolean isEmptyText(String target) {
        return Objects.isNull(target) || target.isEmpty();
    }

}
