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
     * A  ---
     * B    ---
     * C      ---
     */
    @Test
    public void firstTest() throws IncorrectInputFormat {
        String input = "A B\nB A C\nC B";
        assertTrue(isInterval(input));
    }

    /**
     * A  ---
     * B    ---
     * C         ---
     * D           ---
     */
    @Test
    public void secondTest() throws IncorrectInputFormat {
        String input = "A B\nB A\nC D\nD C";
        Graph graph = Utils.readGraphFromString(input);
        assertTrue(!graph.isInterval(false));
    }

    /**
     * A  ---
     * B    ---
     * C  ---
     */
    @Test
    public void thirdTest() throws IncorrectInputFormat {
        String input = "A B C\nB A C\nC A B";
        assertTrue(isInterval(input));
    }

    /**
     * A  ---
     * B         ---
     * C  ---
     * D         ---
     */
    @Test
    public void fourthTest() throws IncorrectInputFormat {
        String input = "A C\nB D\nC A\nD B";
        assertTrue(!isInterval(input));
    }

    /**
     * A  ---
     * B   ----
     * C      --------
     * D        ---
     * E            -----
     */
    @Test
    public void fifthTest() throws IncorrectInputFormat {
        String input = "A B\nB A C\nC B D E\nD C\nE D";
        assertTrue(isInterval(input));
    }

    /**
     * A  ---
     * B   ----
     * C      --------
     * D            -----
     * E                    ----
     * F                     ----
     */
    @Test
    public void sixthTest() throws IncorrectInputFormat {
        String input = "A B\nB A C\nC B D\nD C\nE F\nF E";
        assertTrue(!isInterval(input));
    }

    /**
     * A  ---
     * B   ----
     * C      ----------
     * D         ----
     * E               ----
     */
    @Test
    public void seventhTest() throws IncorrectInputFormat {
        String input = "A B\nB A C\nC B D E\nD C\nE C";
        assertTrue(isInterval(input));
    }

    /**
     * A  -------------------
     * B  ---
     * C        ------
     * D                 -------
     */
    @Test
    public void eighthTest() throws IncorrectInputFormat {
        String input = "A B C D\nB A\nC A\nD A";
        assertTrue(isInterval(input));
    }
}
