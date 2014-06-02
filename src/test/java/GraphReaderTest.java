import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gis.Graph;
import gis.GraphReader;
import gis.error.IncorrectInputFormat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import utils.Utils;

/**
 * Tests {{gis.GraphReader}} class.
 */
public class GraphReaderTest {

	@Test
	public void testRead() throws IncorrectInputFormat {
		String input = "A B C\nB A\nC A";
		Graph graph = Utils.readGraphFromString(input);
		assertEquals(graph.size(), 3);
	}

	@Test
	public void testReadIncorrectFormat() {
		String input = "A B C\nB A\nC";

		String errorMessage = "";

		try {
            Utils.readGraphFromString(input);
		} catch (IncorrectInputFormat e) {
			errorMessage = e.getMessage();
		}

		assertTrue(errorMessage.contains("Not enough parameters in line"));
	}
}
