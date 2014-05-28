import gis.Graph;
import gis.GraphReader;
import gis.error.IncorrectInputFormat;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests {{gis.GraphReader}} class.
 */
public class GraphReaderTest {

    @Test
    public void testRead() throws IncorrectInputFormat {
        String input = "A B C\nB A\nC A";
        Graph graph = GraphReader.read(input);
        assertEquals(graph.size(), 3);
    }

    @Test
    public void testReadIncorrectFormat() {
        String input = "A B C\nB A\nC";

        try {
            GraphReader.read(input);
        } catch (IncorrectInputFormat e) {
            assertTrue(e.getMessage().contains(""));
        }
    }
}
