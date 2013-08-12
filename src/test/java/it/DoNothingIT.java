package it;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoNothingIT extends AbstractCargoIT {

	@Test
	public void testSanity() {
		System.out.println("RUNNING SANITY");
		assertTrue(true);
	}
}
