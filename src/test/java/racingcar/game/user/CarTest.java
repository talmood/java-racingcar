package racingcar.game.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Fixture.CarFixture;
import racingcar.Fixture.UserFixture;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("전진 임계값보다 작을 때")
    @Test
    public void Test1() {
        final User user = UserFixture.getValidUser();
        final int lowerForwardThreshold = CarFixture.getLowerForwardThreshold();
        user.getCar().forward(lowerForwardThreshold);
        assertEquals(user.getCar().getPosition(),  0);
    }

    @DisplayName("전진 임계값보다 같을 때")
    @Test
    public void Test2() {
        final User user = UserFixture.getValidUser();
        final int lowerForwardThreshold = CarFixture.getEqualForwardThreshold();
        user.getCar().forward(lowerForwardThreshold);
        assertEquals(user.getCar().getPosition(),  0);
    }

    @DisplayName("전진 임계값보다 클 때")
    @Test
    public void Test3() {
        final User user = UserFixture.getValidUser();
        final int lowerForwardThreshold = CarFixture.getUpperForwardThreshold();
        user.getCar().forward(lowerForwardThreshold);
        assertEquals(user.getCar().getPosition(),  1);
    }

}