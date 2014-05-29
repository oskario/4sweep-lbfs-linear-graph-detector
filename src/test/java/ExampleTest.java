import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

	@Test
	public void testPasses() {
		String expected = "Hello, JUnit!";
		String hello = "Hello, JUnit!";
		assertEquals(hello, expected);
	}
}