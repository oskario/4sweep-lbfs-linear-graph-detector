package gis.lbfs;

import gis.Graph;
import gis.Node;

import java.util.List;

public class Plus implements LBFS {
	
	private Graph graph;
	
	private List<Node> nodes;
	
	private Node startNode;
	
	public Plus(Graph g, List<Node> t) {
		this.graph = g;
		this.nodes = t;
		
		// Starting node is the last of list t
		this.startNode = t.get(t.size() - 1);
	}
	
	public List<Node> run() {
		return null;
	}
}
