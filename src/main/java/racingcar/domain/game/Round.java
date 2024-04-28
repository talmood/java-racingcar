package racingcar.domain.game;

public class Round {

	private final int totalRound;
	private int currentRound;

	public Round(final int round) {
		this.totalRound = round;
		this.currentRound = 0;
	}

	public void play() {
		if (this.currentRound < this.totalRound) {
			this.currentRound++;
		}
	}

	public boolean isFinished() {
		return this.currentRound == this.totalRound;
	}

	public int getCurrentRound() {
		return this.currentRound;
	}
}
