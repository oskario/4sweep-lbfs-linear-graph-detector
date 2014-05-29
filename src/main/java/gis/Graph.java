package gis;

import gis.lbfs.Generic;
import gis.lbfs.Plus;
import gis.lbfs.Star;

import java.util.Iterator;
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
        try {
            Generic generic = new Generic(this);
            Result sigma = generic.start();
            System.out.println("SIGMA:");
            sigma.print();

            if (sigma != null) {
                this.clean();
                Plus plus = new Plus(this, sigma);
                Result sigmaPlus = plus.start();
                System.out.println("SIGMA PLUS:");
                sigmaPlus.print();

                if (sigmaPlus != null) {
                    Result iPlus = getIplus(this, sigmaPlus);
                    System.out.println("I+:");
                    iPlus.print();

                    ResultWithNeighbours aNbrs = ABNeighbors(this, sigmaPlus);
                    System.out.println("A:");
                    aNbrs.print();

                    this.clean();

                    plus = new Plus(this, sigmaPlus);
                    Result sigmaPlusPlus = plus.start();
                    System.out.println("SIGMA PLUS PLUS:");
                    sigmaPlusPlus.print();

                    if (sigmaPlusPlus != null) {
                        Result iPlusPlus = getIplus(this, sigmaPlusPlus);
                        System.out.println("I++:");
                        iPlusPlus.print();

                        ResultWithNeighbours bNbrs = ABNeighbors(this, sigmaPlusPlus);
                        System.out.println("B:");
                        bNbrs.print();

                        this.clean();

                        Star star = new Star(this, sigmaPlus, sigmaPlusPlus, iPlus, iPlusPlus, aNbrs, bNbrs);
                        Result sigmaStar = star.start();
                        System.out.println("SIGMA*:");
                        sigmaStar.print();
                        if (sigmaStar != null)
                            return true;
                    }
                }
            }
            return true;
        }
        catch(Exception e) {
            return false;
        }
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

    public void clean()
    {
        for (Node n: nodes)
        {
            n.reset();
        }
    }

    private Result getIplus(Graph g, Result result)
    {
        Result iPlus = new Result();

        for (NodeNameWithNumber aResult : result) {
            String nodeName = aResult.getName();
            Node node = g.getNodeByName(nodeName);
            int max = 0;
            for (String neighbour : node.getNeighbours()) {
                Node n = g.getNodeByName(neighbour);
                if (n.getNumber() > max)
                    max = n.getNumber();
            }
            iPlus.add(new NodeNameWithNumber(nodeName, max));
        }

        return iPlus;
    }

    /**
     * It computes A(v) OR B(v), where v is a vertex in the given graph.
     * A(v) and B(v) are the set of neighbors of v that are
     * before v in sigma+ and sigma++ respectively, and are
     * adjacent to a vertex after v in sigma+ and sigma++
     * respectively.
     * @param graph
     * @param result
     * @return result with neighbours
     */
    private ResultWithNeighbours ABNeighbors(Graph graph, Result result)
    {
        ResultWithNeighbours abNbrs = new ResultWithNeighbours();

        for (int i = 0; i < result.size(); i++)
        {
            String nodeName = result.get(i).getName();
            Node node = graph.getNodeByName(nodeName);
            int max = node.getNumber();
            LinkedList<String> listNbrs = new LinkedList<String>();
            for (int x = 0; x < (node.getNumber()-1); x++)
            {
                String beforeName = result.get(x).getName();
                Node n = graph.getNodeByName(beforeName);
                Iterator<String> it = n.getNeighbours().iterator();
                boolean done = false;
                while (it.hasNext())
                {
                    String nbr = it.next();
                    for (int y = node.getNumber(); y < result.size(); y++)
                    {
                        String after = result.get(y).getName();
                        if (nbr.equals(after))
                        {
                            listNbrs.add(beforeName);
                            done = true;
                            break;
                        }
                    }
                    if (done)
                        break;
                }
            }
            abNbrs.put(nodeName, new Node(nodeName, listNbrs));
        }

        return abNbrs;
    }
}
