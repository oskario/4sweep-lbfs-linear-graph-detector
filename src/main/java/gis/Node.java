package gis;

import java.util.ArrayList;
import java.util.LinkedList;
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
     * Node number
     */
    private int number = 0;

	/**
	 * Node's neighbours.
	 */
	private List<String> neighbours = new LinkedList<String>();

    /**
     * Node's labels.
     */
    private List<Integer> labels = new LinkedList<Integer>();

	public Node(String name) {
		this.name = name;
	}

	public Node(String name, List<String> neighbours) {
		this.name = name;
		this.neighbours = neighbours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<String> neighbours) {
		this.neighbours = neighbours;
	}

    public List<Integer> getLabels() {
        return labels;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
	 * Add new neighbour.
	 * 
	 * @param neighbour
	 *            new neighbour node
	 */
	public void addNeighbour(String neighbour) {
		if (this.neighbours != null) {
			this.neighbours.add(neighbour);
		}
	}

    public void addLabel(int label) {
       if (this.labels != null) {
           this.labels.add(label);
       }
    }

    /**
     * Compare two integer arrays lexicographically.
     *
     * @param list1 Array 1 of integers
     * @param list2 Array 2 of integers
     * @return 0 if both are equal, 1 if array1 is greater and
     *         -1 if array2 is greater
     */
    public int orderedSetComparison(List<Integer> list1, List<Integer> list2)
    {
        List<Integer> arr1 = list1;
        List<Integer> arr2 = list2;
        if (list1.size() < list2.size())
        {
            arr1 = list2;
            arr2 = list1;
        }
        for (int i = 0; i < arr1.size(); i++)
        {
            int a1 = arr1.get(i);
            int a2 = arr2.get(i);
            if (a1 > a2)
                return 1;
            else if (a1 < a2)
                return -1;
        }
        if (arr2.size() > arr1.size())
            return -1;
        return 0;
    }

    public void reset() {
        labels = new ArrayList<Integer>();
        number = 0;
    }
}
