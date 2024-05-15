package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class CommaStringSplitter implements StringSplitter {

    private static final String STRING_DELIMITER = ",";

    @Override
    public List<String> split(String str) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException("split string must not be blank");
        }

        return Arrays.stream(str.split(STRING_DELIMITER)).toList();
    }
}
