package crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {

	@Test
	public void testEncoding() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		assertTrue(encoder.matches("hello",
				"$2a$10$gdspaDSU0lLH1NKF3JA.GuoPgL4cJMr2yWtaR36FmiA7LsjWfgxcC"));
	}

	@Test
	public void testLength() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("hello");
		assertEquals(60, encoded.length());
	}

}
