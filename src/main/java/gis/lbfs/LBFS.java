package gis.lbfs;

import gis.Node;
import gis.Result;

import java.util.List;

/**
 * Generic Lexicographic Breadth First Search (LBFS) Algorithm.
 */
public interface LBFS {

	/**
	 * Executes the algorithm.
	 * 
	 * @return ordered list of nodes
	 */
	public Result start();
    public Node getStartingNode();
}
