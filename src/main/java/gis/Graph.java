package gis;

import gis.lbfs.Generic;

import java.util.LinkedList;
import java.util.List;

/**
 * The graph itself.
 */
public class Graph {

	/**
	 * List of graph's nodes.
	 */
	private List<Node> nodes;

	public Graph() {
		this.nodes = new LinkedList<Node>();
	}

	public Graph(List<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Detects weather graph is interval.
	 * 
	 * @return true if the graph is interval, otherwise false
	 */
	public boolean isInterval() {
        Generic generic = new Generic(this);
        Result result = generic.start();
        result.print();
		return true;
	}

	/**
	 * Returns the size of the graph (number of nodes).
	 * 
	 * @return number of nodes in the graph
	 */
	public int size() {
		if (this.getNodes() != null)
			return this.getNodes().size();
		else
			return 0;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		if (this.nodes != null) {
			this.nodes.add(node);
		}
	}

    public Node getNodeByName(String neighbourName) {
        for(Node node : this.nodes) {
            if (node.getName().equals(neighbourName)) {
                return node;
            }
        }
        return null;
    }
}
