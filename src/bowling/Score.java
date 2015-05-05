package bowling;

public class Score {
	
	private final String[] tries;
	
	public Score(String frames) {
		tries = frames.split(" ");
	}

	public int total() {
		int sum = 0;
		for (String aTry : tries) {
			sum += Integer.valueOf(aTry);
		}
		return sum;
	}
}
