package lbfs;

import gis.Graph;
import gis.Node;

import java.util.List;

public class Generic implements LBFS {
	
	private Graph graph;
	private Node startNode;
	
	/**
	 * Creates new generic LBFS algorithm instance.
	 * @param g target graph
	 * @param u node to begin with
	 */
	public Generic(Graph g, Node u) {
		this.graph = g;
		this.startNode = u;
	}

	public List<Node> run() {
		return null;
	}
}
