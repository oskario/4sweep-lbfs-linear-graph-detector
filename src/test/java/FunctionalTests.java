import gis.Graph;
import gis.error.IncorrectInputFormat;
import org.junit.Test;
import utils.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FunctionalTests {

    /**
     * Creates graph from given input and returns isInterval
     * @param input graph in string
     * @return isInterval
     * @throws IncorrectInputFormat
     */
    private Boolean isInterval(String input) throws IncorrectInputFormat {
        Graph graph = Utils.readGraphFromString(input);
        return graph.isInterval(false);
    }

    /**
     * Tested set of intervals:
     *
     * A  ---
     * B    ---
     * C      ---
     */
    @Test
    public void firstTest() throws IncorrectInputFormat {
        String input = "A B\nB A\nC B";
        assertTrue(isInterval(input));
    }

    /**
     * Tested set of intervals:
     *
     * A  ---
     * B    ---
     * C         ---
     * D           ---
     */
    @Test
    public void secondTest() throws IncorrectInputFormat {
        String input = "A B\nB A\nC D\nD C";
        Graph graph = Utils.readGraphFromString(input);
        assertTrue(graph.isInterval(false));
    }

    /**
     * Tested set of intervals:
     *
     * A  ---
     * B    ---
     * C         ---
     * D           ---
     */
    @Test
    public void thirdTest() throws IncorrectInputFormat {
        String input = "A B\nB A\nC D\nD C";
        assertTrue(!isInterval(input));
    }
}
