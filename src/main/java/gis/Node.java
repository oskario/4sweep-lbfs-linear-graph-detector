package gis;

import java.util.List;

/**
 * Represents single node in the graph.
 */
public class Node {

    /**
     * Name of the node.
     */
    private String name;

    /**
     * Node's value.
     */
    private Object value;

    /**

     * Node's neighbours.
     */
    private List<Node> neighbours;

    public Node(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Node(String name, Object value, List<Node> neighbours) {
        this.name = name;
        this.value = value;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
