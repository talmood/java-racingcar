package racingcar;

import java.util.List;

public class RacingGamePlayer {

    public RacingCars ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarNamesCreator carNamesCreator = new UserInputCarNamesCreator();
        List<CarName> carNames = carNamesCreator.create();

        RacingCarsCreator racingCarsCreator = new ThresholdRacingCarCreator();
        return racingCarsCreator.createByCarNames(carNames);
    }

    public RacingCars play(RacingCars racingCars) {
        System.out.println("시도할 회수는 몇회인가요?");
        RacingCarsMover racingCarsMover = new RandomRacingCarsMover();
        return racingCarsMover.moveForwardManyTimes(racingCars);
    }

    public void ending(RacingCars racingCars) {
        RacingWinnerFinder racingWinnerFinder = new RacingWinnerFinder();
        RacingCars racingWinners = racingWinnerFinder.find(racingCars);

        String winnerNamesWithJoin = racingWinners.getCarNamesWithJoin(",");
        System.out.print("최종 우승자 : ");
        System.out.println(winnerNamesWithJoin);
    }
}
