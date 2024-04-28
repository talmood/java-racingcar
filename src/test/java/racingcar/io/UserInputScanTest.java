package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Fixture.UserInputScanFixture;

import static org.junit.jupiter.api.Assertions.*;

class UserInputScanTest {

    final UserInputScan userInputScan = new UserInputScan();

    @DisplayName("사용자 이름 , 로 분리해서 입력")
    @Test
    public void Test01() {
        // 테스트할 문자열 입력
        final String userInput = UserInputScanFixture.getNameDefault();
        final String[] userInputArray = UserInputScanFixture.getNameArrayDefault();

        // 테스트 대상 메서드 호출
        final UserInputScan userInputScan = new UserInputScan(); // YourClass는 실제 코드에서 사용하는 클래스 이름으로 대체해야 합니다.
        final String[] result = userInputScan.validationUserName(userInput);
        // 예상 결과와 비교
        assertArrayEquals(userInputArray, result);
    }

    @DisplayName("라운드 입력 양수")
    @Test
    public void Test02() {
        // 빈 문자열을 입력으로 테스트
        final String roundStringDefault = UserInputScanFixture.getRoundStringDefault();
        final int roundIntDefault = UserInputScanFixture.getRoundIntDefault();

        // 테스트 대상 메서드 호출
        final UserInputScan userInputScan = new UserInputScan(); // YourClass는 실제 코드에서 사용하는 클래스 이름으로 대체해야 합니다.
        int numberOfPlayRound = userInputScan.validationNumberOfPlayRound(roundStringDefault);
        // 예상 결과와 비교
        assertEquals(numberOfPlayRound, roundIntDefault);
    }

    @DisplayName("라운드 입력 음수")
    @Test
    public void Test03() {
        // 빈 문자열을 입력으로 테스트
        final String roundStringDefault = UserInputScanFixture.getMinusRoundString();
        // 테스트 대상 메서드 호출
        final UserInputScan userInputScan = new UserInputScan(); // YourClass는 실제 코드에서 사용하는 클래스 이름으로 대체해야 합니다.
        // 예상 결과와 비교
        assertThrows(IllegalArgumentException.class, () -> {
            userInputScan.validationNumberOfPlayRound(roundStringDefault);
        });

    }
}