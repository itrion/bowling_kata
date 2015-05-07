package bowling;

public class Score {
	
	private final String[] framesScores;
	
	public Score(String frames) {
		this.framesScores = frames.split(" ");
	}
	
	public int total() {
		int grandTotal = 0;
		for (int frame = 0; frame < 10; frame++) {
			grandTotal += totalForFrame(frame);
		}
		return grandTotal;
	}
	
	private int totalForFrame(int frame) {
		if (isStrike(frame)) return 20 + baseTotalForFrame(frame + 1);
		int totalForFrame = firstThrow(frame) + secondThrow(frame);
		if (totalForFrame == 10) totalForFrame += baseTotalForFrame(frame + 1);
		return totalForFrame;
	}
	
	private int baseTotalForFrame(int frame) {
		if (isStrike(frame)) return 10;
		return firstThrow(frame) + secondThrow(frame);
	}

	private boolean isStrike(int frame) {
		return framesScores[frame].equals("X");
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
