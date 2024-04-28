package racingcar.game.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Fixture.UserFixture;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @DisplayName("사용자 이름 5글자 이하로 입력")
    @Test
    public void Test1() {
        final String validLengthName = UserFixture.getValidLengthName();
        final User user = new User(validLengthName);
        assertEquals(validLengthName, user.getName());
    }


    @DisplayName("사용자 이름 5글자 이상으로 입력")
    @Test
    public void Test2() {
        final String invalidLengthName = UserFixture.getInvalidLengthName();
        assertThrows(IllegalArgumentException.class, () -> {
            final User user = new User(invalidLengthName);
        });
    }

    @DisplayName("사용자 이름 0글자 입력")
    @Test
    public void Test3() {
        final String emptyName = UserFixture.getEmptyName();
        assertThrows(IllegalArgumentException.class, () -> {
            final User user = new User(emptyName);
        });
    }

    @DisplayName("초기 유저 상태 출력")
    @Test
    public void Test4() {
        final User validUser = UserFixture.getValidUser();
        final String validUserStatusText = UserFixture.getUserStatusText(validUser);
        validUser.displayStatus();
        String output = outputStreamCaptor.toString().trim();
        assertEquals(validUserStatusText, output);
    }

    @DisplayName("전진 1번 유저 상태 출력")
    @Test
    public void Test5() {
        final User forwardValidUser = UserFixture.getForwardValidUser();
        final String validUserStatusText = UserFixture.getUserStatusText(forwardValidUser);
        forwardValidUser.displayStatus();
        String output = outputStreamCaptor.toString().trim();
        assertEquals(validUserStatusText, output);
    }
}