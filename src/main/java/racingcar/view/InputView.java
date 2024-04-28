package racingcar.view;

import racingcar.model.RacingCarName;
import racingcar.model.RacingCarNames;
import racingcar.utils.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NAME_LITERALS_PATTERN = Pattern.compile("^[가-힣0-9a-zA-Z,]*$");
    private static final String NAME_SEPARATOR = ",";

    private final InputReader inputReader;
    private final OutputPrinter outputPrinter;

    public InputView(final InputReader inputReader, final OutputPrinter outputPrinter) {
        this.inputReader = inputReader;
        this.outputPrinter = outputPrinter;
    }

    public RacingCarNames inputCarNames() {
        outputPrinter.printLine(UserGuideMessage.INPUT_RACING_CAR_NAME.getMessage());
        final String inputMessage = inputReader.readLine();

        validateCarNameFormat(inputMessage);
        validateAtLeastOneNameExists(inputMessage);

        return createRacingCarNames(inputMessage);
    }

    private RacingCarNames createRacingCarNames(final String inputMessage) {
        return new RacingCarNames(Arrays.stream(splitWithSeparator(inputMessage))
                .map(RacingCarName::new)
                .toList());
    }

    private void validateCarNameFormat(final String nameLiterals) {
        if (!StringUtils.hasText(nameLiterals)) {
            throw new IllegalArgumentException("Literal of RacingCarNames must not be null or empty");
        }

        if (!NAME_LITERALS_PATTERN.matcher(nameLiterals).matches()) {
            throw new IllegalArgumentException("Literal of RacingCarNames must not contain special character except ','");
        }
    }

    private void validateAtLeastOneNameExists(final String nameLiterals) {
        if (splitWithSeparator(nameLiterals).length < 1) {
            throw new IllegalArgumentException("Literal of RacingCarNames must contain at least one name.");
        }
    }

    private String[] splitWithSeparator(final String nameLiterals) {
        return nameLiterals.split(NAME_SEPARATOR);
    }

}
