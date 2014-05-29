package gis.lbfs;

import gis.Graph;
import gis.Node;
import gis.NodeNameWithNumber;
import gis.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GeneralProcedure {
    private int size = 0;
    protected Result result = new Result();
    protected Graph graph;

    public GeneralProcedure(Graph graph) {
        this.graph = graph;
    }

    public void run(Node node) {
        if (node != null) {
            size++;
            node.setNumber(size);
            result.add(new NodeNameWithNumber(node.getName(), node.getNumber()));
            Node nextNode = appendLabelToNeighbors(node.getNeighbours(), node.getNumber());
            run(nextNode);
            for (String neighbour : node.getNeighbours()) {
                node = graph.getNodeByName(neighbour);
                node = appendLabelToNeighbors(node.getNeighbours(), node.getNumber());
                run(node);
            }
        }
    }

    /**
     * Adds number to the labels of all neighbours if number <= 0.
     * Then selects the neighbour which is lexicographically the largest.
     * In case all are numbered then returns null.
     * @param neighbours to append the label
     * @param number if > 0 - append to nodes
     * @return selected node or null
     */
    private Node appendLabelToNeighbors(List<String> neighbours, int number) {
        ArrayList<Node> l = new ArrayList<Node>();
        /** Actual node. */
        Node n = null;
        Node max = null;
        for (String neighbour : neighbours) {
            n = graph.getNodeByName(neighbour);
            if (n.getNumber() <= 0) {
                l.add(n);
                if (number > 0)
                    n.addLabel(number);
                /*
				* Select the lexicographically largest label
				*/
                if (max == null || n.orderedSetComparison(n.getLabels(), max.getLabels()) > 0)
                    max = n;
            }
        }
		/*
		* If lexicographically largest then check if others have the same label.
		* If there are, then there is a TIE.
		*/
        if (max != null && max.getLabels().size() > 1)
        {
            List<Integer> labels = max.getLabels();
            String name = max.getName();
            ArrayList<Node> equalNodes = new ArrayList<Node>();
            for (Node aL : l) {
                n = aL;
                if (!n.getName().equals(name) && n.orderedSetComparison(n.getLabels(), labels) == 0)
                    equalNodes.add(n);
            }
            if (equalNodes.size() > 0)
            {
                l = equalNodes;
            }
        }
		/*
		* If there is a TIE then randomly select one of the neighbors
		*/
        if (max != null && max.getLabels().size() < 2 && l.size() > 0)
        {
            max = selectInCaseOfTie(l);
        }
		/*
		* All the neighbors are numbered, so return null
		*/
        else if (max == null || max.getLabels().size() < 2)
            return null;

        return max;
    }

    public abstract Node selectInCaseOfTie(ArrayList<Node> l);
}
