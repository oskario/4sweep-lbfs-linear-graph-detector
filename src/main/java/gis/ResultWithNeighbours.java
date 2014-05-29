package gis;

import java.util.*;

/**
 * Stores A(v) / B(v) from the 4 LBFS sweeps of IGR Algorithm,
 * where v is a vertex in the graph.
 */
public class ResultWithNeighbours extends Hashtable<String, Node> {

    /**
     * Get size of neighbours of node of given name
     *
     * @param name node name
     * @return size of neighbours
     */
    public int getSize(String name)
    {
        for (Node node : this.values()) {
            if (node.getName().equals(name))
                return node.getNeighbours().size();
        }
        return 0;
    }

    /**
     * Get a random Node
     *
     * @return random node
     */
    public String getRandom()
    {
        Object[] nodes = this.values().toArray();
        int random = new Random().nextInt(nodes.length-1);
        Node node = (Node)nodes[random];
        return node.getName();
    }

    public void print()
    {
        for (Node node : this.values()) {
            node.print();
            System.out.println();
        }
    }
}
