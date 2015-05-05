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

	private Integer secondTryPunctuation(int frame) {
		return new Integer(framesScores[frame].substring(1, 2));
	}

	private Integer firstTryPunctuation(int tryIndex) {
		return new Integer(framesScores[tryIndex].substring(0, 1));
	}
}
