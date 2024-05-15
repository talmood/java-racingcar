package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

class CollectionUtilsTest {

    static Stream<Collection<?>> isEmptyMethodSource() {
        return Stream.of(null, Collections.emptyList());
    }

    @ParameterizedTest
    @MethodSource("isEmptyMethodSource")
    @DisplayName("isEmpty()")
    void isEmpty(Collection<?> collection) {
        boolean isEmpty = CollectionUtils.isEmpty(collection);

        Assertions.assertThat(isEmpty).isEqualTo(true);
    }

}