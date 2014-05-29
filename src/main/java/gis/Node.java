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
	 * Node's neighbours.
	 */
	private List<Node> neighbours;

	public Node(String name) {
		this.name = name;
	}

	public Node(String name, List<Node> neighbours) {
		this.name = name;
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

	/**
	 * Add new neighbour.
	 * 
	 * @param node
	 *            new neighbour node
	 */
	public void addNeighbour(Node node) {
		if (this.neighbours != null) {
			this.neighbours.add(node);
		}
	}
}
