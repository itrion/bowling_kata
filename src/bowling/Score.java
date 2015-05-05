package bowling;

public class Score {
	
	private final String[] framesScores;
	
	public Score(String frames) {
		this.framesScores = frames.split(" ");
	}

	public int total() {
		int grandTotal = 0;
		for (int frame = 0; frame < framesScores.length; frame++) {
			grandTotal += totalForFrame(frame);
		}
		return grandTotal;
	}
	
	private int totalForFrame(int frame) {
		int totalForFrame = firstTryPunctuation(frame) + secondTryPunctuation(frame);
		if (totalForFrame == 10) totalForFrame += totalForFrame(frame + 1);
		return totalForFrame;
	}

	private Integer firstTryPunctuation(int frame) {
		return new Integer(tryPunctuation(frame, 0));
	}

	private Integer secondTryPunctuation(int frame) {
		return new Integer(tryPunctuation(frame, 1));
	}

	private String tryPunctuation(int frame, int tryNumber) {
		return framesScores[frame].substring(tryNumber, tryNumber + 1).replace("X", "10");
	}
}
