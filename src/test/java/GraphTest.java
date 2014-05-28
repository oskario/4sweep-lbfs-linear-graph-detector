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

    @Test
    public void testSize() throws Exception {
        Graph graph = new Graph();

        assertEquals(graph.size(), 0);

        graph = new Graph();
        graph.addNode(new Node("A", 1));
        graph.addNode(new Node("B", 2));
        graph.addNode(new Node("C", 3));

        assertEquals(graph.size(), 3);

        List<Node> nodes = new LinkedList<Node>() {};
        nodes.add(new Node("D", 4));
        nodes.add(new Node("E", 5));
        nodes.add(new Node("F", 6));
        nodes.add(new Node("G", 7));
        graph = new Graph(nodes);

        assertEquals(graph.size(), 4);
    }
}
