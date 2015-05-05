package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreTest {
	
	@Test
	public void should_be_zero_when_all_frames_are_zero() {
		String frames = "00 00 00 00 00 00 00 00 00 00";
		assertThat(new Score(frames).total(), is(0));
	}
	
	@Test
	public void should_be_a_flat_sum_of_frames_when_no_spare_or_strike() {
		String frames = "01 01 01 01 01 01 01 01 01 01";
		assertThat(new Score(frames).total(), is(10));
	}
	
	@Test
	public void should_count_a_spare() {
		String frames = "55 50 00 00 00 00 00 00 00 00";
		assertThat(new Score(frames).total(), is(20));
	}
	
	@Test
	public void should_count_a_strike() {
		String frames = "XX 50 00 00 00 00 00 00 00 00";
		assertThat(new Score(frames).total(), is(25));
	}
}
