package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;


public class UserInput implements UserInputCondition {

    @Override
    public  String[] acceptRacingCarNames() {
        String carNamesInput = acceptInputForGuideMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validateUserInput.validateRacingCarNames(carNamesInput);
    }

    @Override
    public int acceptTrialTimes() {
        String trialTimesInput = acceptInputForGuideMessage("시도할 회수는 몇회인가요?");
        return validateUserInput.validateTrialTimes(trialTimesInput);
    }

    private static class validateUserInput {
        private static String[] validateRacingCarNames (String carNames) {
            validateBlank(carNames);
            validateCommaExists(carNames);
            String[] names = carNames.split(",");
            for (String name: names) {
                validateCarNameDigits(name);
            }
            return names;
        }
        private static void validateBlank(String text) {
            if (StringUtils.isBlank(text)) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateCommaExists(String text) {
            if (!text.contains(",")) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateCarNameDigits(String text) {
            if (text.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        static int validateTrialTimes(String trialTimesInput) {
            validateBlank(trialTimesInput);

            int trialTimes = validateNumberFormat(trialTimesInput);
            int minTrialTimes = 1;
            int maxTrialTimes = 100; //조건에는 없지만 임의의 MAX값을 지정

            if (trialTimes < minTrialTimes) {
                throw new IllegalArgumentException();
            }

            if (trialTimes > maxTrialTimes) {
                throw new IllegalArgumentException();
            }

            return trialTimes;
        }

        private static int validateNumberFormat(String text) {
            int convertedInt;
            try {
                convertedInt = Integer.parseInt(text);
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException();
            }
            return convertedInt;
        }

    }

    private String acceptInputForGuideMessage(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

}
