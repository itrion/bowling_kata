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
		if (exceedingFrameNumbers(frame)) return 0;
		int totalForFrame = firstTryPunctuation(frame) + secondTryPunctuation(frame);
		if (totalForFrame >= 10) totalForFrame += totalForFrame(frame + 1);
		return totalForFrame;
	}

	private boolean exceedingFrameNumbers(int frame) {
		return frame == framesScores.length;
	}

	private Integer firstTryPunctuation(int frame) {
		return new Integer(throwPunctuation(frame, 0));
	}

	private Integer secondTryPunctuation(int frame) {
		return new Integer(throwPunctuation(frame, 1));
	}

	private String throwPunctuation(int frame, int throwNumber) {
		return framesScores[frame].substring(throwNumber, throwNumber + 1).replace("X", "10");
	}
}
