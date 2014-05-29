package gis.lbfs;

import gis.Graph;
import gis.Node;
import gis.Result;

import java.util.ArrayList;
import java.util.Random;

public class Plus extends GeneralProcedure implements LBFS {

    private final Result lastResult;

    public Plus(Graph g, Result lastResult) {
        super(g);
        this.lastResult = lastResult;
    }

    public Result start() {
        Node node = getStartingNode();
        node.addLabel(graph.size());
        run(node);
        if (this.result.size() < graph.size())
            return null;
        else
            return this.result;
    }

    public Node getStartingNode() {
        String lastNodeName = lastResult.get(lastResult.size()-1).getName();
        return graph.getNodeByName(lastNodeName);
    }

    public Node selectInCaseOfTie(ArrayList<Node> l) {
        Node max;

        String name = lastResult.getNodeWithMinNumber(l);
        max = graph.getNodeByName(name);

        return max;
    }
}
