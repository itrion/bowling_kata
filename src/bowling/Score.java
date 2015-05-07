package bowling;

public class Score {
	
	private static final int MAX_FRAMES = 10;
	private static final int STRIKE_POINTS = 20;
	private static final int SPARE_POINTS = 10;
	private static final int FIRST_FRAME = 0;
	private static final int FLAT_TOTAL_WHEN_STRIKE_OR_SPARE = 10;
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
		if (isStrike(frame)) return STRIKE_POINTS + flatTotal(frame + 1);
		if (isSpare(frame)) return SPARE_POINTS + flatTotal(frame + 1);
		return flatTotal(frame);
	}

	private int flatTotal(int frame) {
		if (isStrike(frame) || isSpare(frame)) return FLAT_TOTAL_WHEN_STRIKE_OR_SPARE;
		return firstThrow(frame) + secondThrow(frame);
	}

	private boolean isStrike(int frame) {
		return framesScores[frame].equals("X");
	}

	private boolean isSpare(int frame) {
		return firstThrow(frame) + secondThrow(frame) == 10;
	}

	private Integer firstThrow(int frame) {
		return new Integer(throwPunctuation(frame, 0));
	}
	
	private Integer secondThrow(int frame) {
		return new Integer(throwPunctuation(frame, 1));
	}
	
	private String throwPunctuation(int frame, int throwNumber) {
		return framesScores[frame].substring(throwNumber, throwNumber + 1);
	}
}
