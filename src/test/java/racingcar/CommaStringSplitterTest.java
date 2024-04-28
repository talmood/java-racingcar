package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CommaStringSplitterTest {

    @Test
    @DisplayName("split()")
    void split() {
        String str = "pobi,woni,jun";
        CommaStringSplitter splitter = new CommaStringSplitter();
        List<String> split = splitter.split(str);

        assertThat(split.size()).isEqualTo(3);
        assertThat(split).containsOnly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("split()_empty_str")
    void split_empty_str() {
        String str = " ";
        CommaStringSplitter splitter = new CommaStringSplitter();

        assertThatThrownBy(() -> splitter.split(str)).isInstanceOf(IllegalArgumentException.class);
    }
}