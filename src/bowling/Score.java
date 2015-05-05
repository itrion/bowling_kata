package bowling;

public class Score {
	
	private final String[] framesScores;
	
	public Score(String frames) {
		this.framesScores = frames.split(" ");
	}

	public int total() {
		int sum = 0;
		for (int frame = 0; frame < framesScores.length; frame++) {
			sum += totalForFrame(frame);
		}
		return sum;
	}
	
	private int totalForFrame(int frame) {
		return firstTryPunctuation(frame) + secondTryPunctuation(frame);
	}

	private Integer secondTryPunctuation(int frame) {
		return new Integer(framesScores[frame].substring(1, 2));
	}

	private Integer firstTryPunctuation(int tryIndex) {
		return new Integer(framesScores[tryIndex].substring(0, 1));
	}
}
