package crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {

	@Test
	public void testEncodingVettel87a() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		assertTrue(encoder.matches("vettel87",
				"$2a$10$a3WSjOe3BwdL/ou6STvPcuI6ikpm6vOVnz8qIeGAdfwGaZBEPoIFW"));
	}

	@Test
	public void testEncodingVettel87b() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		assertTrue(encoder.matches("vettel87",
				"$2a$10$SJF.osDLAcg6WmToYT7TW.6iJe7wh.JghWUFt91xHnQSCPARM3F7u"));
	}

	@Test
	public void testEncodingAdmin() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		assertTrue(encoder.matches("admin",
				"$2a$10$3Frma5rvcwKUi9EkIxP6nejNWh9Ex9nak6KljbR/khHTcFQjUQF26"));
	}

	@Test
	public void testEncoding() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		assertTrue(encoder.matches("hello",
				"$2a$10$gdspaDSU0lLH1NKF3JA.GuoPgL4cJMr2yWtaR36FmiA7LsjWfgxcC"));
	}

	@Test
	public void testLengthShort() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("a");
		assertEquals(60, encoded.length());
	}

	@Test
	public void testLengthMiddle() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("hello");
		assertEquals(60, encoded.length());
	}

	@Test
	public void testLengthLong() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder
				.encode("======this should be longer than sixty characters wide.======");
		assertEquals(60, encoded.length());
	}

}
