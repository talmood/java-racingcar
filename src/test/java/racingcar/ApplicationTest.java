package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @DisplayName("자동차 경주 게임은 한 명 이상의 우승자가 나올 수 있다.")
    @Test
    void 여러_우승자_자동차_경주() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,rueun", "1");
                    assertThat(output()).contains("pobi : -", "woni :", "rueun : -", "최종 우승자 : pobi, rueun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 1자 이상 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 최소_참가_자동차_수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("2대 이상의 자동차가 필요합니다.")
        );
    }

    @Test
    void 유효하지_않은_라운드_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("라운드는 양의 정수여야 합니다.")
        );
    }

    @Test
    void 이름이_없는_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    runException("", "1");
                })
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름을 입력해주세요.")
        );
    }

    @Test
    void 최소_참가_자동차_수_미달_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    runException("pobi", "1");
                })
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("2대 이상의 자동차가 필요합니다.")
        );
    }

    @Test
    void 중복된_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    runException("pobi,pobi", "1");
                })
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 자동차 이름이 있습니다.")
        );
    }

    @Test
    void 잘못된_라운드_형식_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("정수 값을 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
