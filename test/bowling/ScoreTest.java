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
	public void should_be_ten_when_all_frames_are_one() {
		String frames = "01 01 01 01 01 10 10 10 10 10";
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
		assertThat(new Score(frames).total(), is(30));
	}
	
	@Test
	public void spare_in_last_turn_gives_another_throw() {
		String frames = "00 00 00 00 00 00 00 00 00 64 10";
		assertThat(new Score(frames).total(), is(12));
	}
	
	@Test
	public void all_throws_as_strike_gives_max_punctuation() {
		String frames = "XX XX XX XX XX XX XX XX XX XX XX XX";
		assertThat(new Score(frames).total(), is(300));
	}
}
