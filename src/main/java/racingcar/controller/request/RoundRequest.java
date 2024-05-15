package racingcar.controller.request;

public class RoundRequest {

	private final int round;

	private RoundRequest(final int round) {
		this.round = round;
	}

	public static RoundRequest from(final String round) {
		RoundInputValidator.validate(round);
		return new RoundRequest(Integer.parseInt(round));
	}

	public int getRound() {
		return this.round;
	}
}
