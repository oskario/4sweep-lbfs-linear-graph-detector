package gis.lbfs;

import gis.Node;

import java.util.List;

public class Star implements LBFS {

	private List<Node> generic;

	private List<Node> plus;

	/**
	 * Creates new instance of LBFS* algorithm.
	 * 
	 * @param generic
	 *            result of generic LBFS algorithm
	 * @param plus
	 *            result of LBFS+ algorithm
	 */
	public Star(List<Node> generic, List<Node> plus) {
		this.generic = generic;
		this.plus = plus;
	}

	public List<Node> run() {
		return null;
	}
}
