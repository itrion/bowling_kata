package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreTest {
	
	@Test
	public void should_be_zero_when_all_frames_are_zero() {
		String frames = "0 0 0 0 0 0 0 0 0 0";
		assertThat(new Score(frames).total(), is(0));
	}
	
	@Test
	public void should_be_a_flat_sum_of_frames_when_no_spare_or_strike() {
		String frames = "1 1 1 1 1 1 1 1 1 1";
		assertThat(new Score(frames).total(), is(10));
	}
}
