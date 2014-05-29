import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gis.Graph;
import gis.GraphReader;
import gis.error.IncorrectInputFormat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Tests {{gis.GraphReader}} class.
 */
public class GraphReaderTest {

    @Test
    public void testRead() throws IncorrectInputFormat {
    	String input = "A B C\nB A\nC A";
        Graph graph = GraphReader.read(splitLines(input));
        assertEquals(graph.size(), 3);
    }

    @Test
    public void testReadIncorrectFormat() {
        String input = "A B C\nB A\nC";
        
        String errorMessage = "";
        
        try {
            GraphReader.read(splitLines(input));
        } catch (IncorrectInputFormat e) {
        	errorMessage = e.getMessage();
        }

        assertTrue(errorMessage.contains("Not enough parameters in line"));
    }
    
    /**
     * Splits given string by newline (\n) character to list of lines.
     * @param in input string
     * @return list of lines
     */
    private List<String> splitLines(String in) {
        return Arrays.asList(in.split("\n"));
    }
}
