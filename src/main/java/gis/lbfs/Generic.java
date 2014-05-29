package gis.lbfs;

import gis.Graph;
import gis.Node;
import gis.NodeNameWithNumber;
import gis.Result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Generic extends GeneralProcedure implements LBFS {

    private int size = 0;

    /**
     * Creates new generic LBFS algorithm instance.
     *
     * @param g target graph
     */
    public Generic(Graph g) {
        super(g);
    }

    public Result start() {
        Node startingNode = getStartingNode();
        startingNode.addLabel(graph.size());
        run(startingNode);
        if (this.result.size() < graph.size())
            return null;
        else
            return this.result;
    }

    public Node getStartingNode() {
        int random = new Random().nextInt(graph.size());
        return graph.getNodes().get(random);
    }

    public Node selectInCaseOfTie(ArrayList<Node> l) {
        Node n;
        Node max;
        int random = new Random().nextInt(l.size());
        n = l.get(random);
        max = graph.getNodeByName(n.getName());
        return max;
    }
}
