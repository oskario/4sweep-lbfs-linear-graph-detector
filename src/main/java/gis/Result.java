package gis;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Helper class to store result
 */
public class Result extends ArrayList<NodeNameWithNumber>  {

    /**
     * Returns a number of the node by given name.
     * @param name
     * @return number
     */
    public int getNumberByName(String name) {
        for (NodeNameWithNumber n : this) {
            if (n.getName().equals(name))
                return n.getNumber();
        }
        return -1;
    }

    /**
     * Gets the node with the minimum number out of the given nodes.
     * @param nodes
     * @return the name of the node with minimum number
     */
    public String getNodeWithMinNumber(ArrayList<Node> nodes)
    {
        String min = null;
        Hashtable<String, NodeNameWithNumber> ht = new Hashtable<String, NodeNameWithNumber>();
        for (NodeNameWithNumber n : this) {
            ht.put(n.getName(), n);
        }
        int minNum = 0;
        for (Node node : nodes) {
            NodeNameWithNumber n = (ht.get(node.getName()));
            if (n.getNumber() > minNum) {
                min = n.getName();
                minNum = n.getNumber();
            }
        }
        ht = null;
        return min;
    }

    /**
     * Returns a number of a node with given name
     * @param node name
     * @return number
     */
    public int getByName(String name)
    {
        for(NodeNameWithNumber n: this) {
            if (n.getName().equals(name))
                return n.getNumber();
        }
        return -1;
    }

    /**
     * For debugging.
     */
    public void print()
    {
        for (NodeNameWithNumber n : this) {
            System.out.println(n.getName() + ": " + n.getNumber());
        }
    }
}
