package bowling;

public class Score {
	
	private final String[] tries;
	
	public Score(String frames) {
		tries = frames.split(" ");
	}

	public int total() {
		int sum = 0;
		for (String aTry : tries) {
			sum += calculateTry(aTry);
		}
		return sum;
	}
	
	private int calculateTry(String aTry) {
		return new Integer(aTry.substring(0, 1)) + new Integer(aTry.substring(1, 2));
	}
}
