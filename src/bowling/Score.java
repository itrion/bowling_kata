package bowling;

public class Score {
	
	private static final int MAX_FRAMES = 10;
	private static final int STRIKE_POINTS = 20;
	private static final int SPARE_POINTS = 10;
	private static final int FIRST_FRAME = 0;
	private final String[] framesScores;
	
	public Score(String frames) {
		this.framesScores = frames.split(" ");
	}
	
	public int total() {
		int grandTotal = 0;
		for (int frame = FIRST_FRAME; frame < MAX_FRAMES; frame++) {
			grandTotal += total(frame);
		}
		return grandTotal;
	}
	
	private int total(int frame) {
		if (isStrike(frame)) return STRIKE_POINTS + firstRoll(frame + 1);
		if (isSpare(frame)) return SPARE_POINTS + firstRoll(frame + 1);
		return firstRoll(frame) + secondRoll(frame);
	}

	private boolean isStrike(int frame) {
		return framesScores[frame].equals("X");
	}

	private boolean isSpare(int frame) {
		return firstRoll(frame) + secondRoll(frame) == 10;
	}

	private Integer firstRoll(int frame) {
		return new Integer(rollPunctuation(frame, 0));
	}
	
	private Integer secondRoll(int frame) {
		return new Integer(rollPunctuation(frame, 1));
	}
	
	private String rollPunctuation(int frame, int throwNumber) {
		return framesScores[frame].substring(throwNumber, throwNumber + 1).replace("X", "10");
	}
}
