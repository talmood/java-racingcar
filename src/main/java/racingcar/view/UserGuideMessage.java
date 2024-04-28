package racingcar.view;

public enum UserGuideMessage {

    INPUT_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ;

    private final String message;

    UserGuideMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
