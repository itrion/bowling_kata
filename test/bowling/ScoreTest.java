package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreTest {
	
	@Test
	public void should_be_zero_when_all_frames_are_zero() {
		String frames = "0 0 0 0 0 0 0 0 0 0 0 0";
		assertThat(new Score(frames).total(), is(0));
	}
}
