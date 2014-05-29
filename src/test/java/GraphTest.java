import gis.Graph;
import gis.Node;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests {{gis.Graph}} class.
 */
public class GraphTest {

    @SuppressWarnings("serial")
	@Test
    public void testSize() throws Exception {
        Graph graph = new Graph();

        assertEquals(graph.size(), 0);

        graph = new Graph();
        graph.addNode(new Node("A"));
        graph.addNode(new Node("B"));
        graph.addNode(new Node("C"));

        assertEquals(graph.size(), 3);

        List<Node> nodes = new LinkedList<Node>() {};
        nodes.add(new Node("D"));
        nodes.add(new Node("E"));
        nodes.add(new Node("F"));
        nodes.add(new Node("G"));
        graph = new Graph(nodes);

        assertEquals(graph.size(), 4);
    }
}
