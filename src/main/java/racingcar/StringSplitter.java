package racingcar;

import java.util.List;

@FunctionalInterface
public interface StringSplitter {

    List<String> split(String str);
}
