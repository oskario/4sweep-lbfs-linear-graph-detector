package gis.lbfs;

import gis.Graph;
import gis.Node;
import gis.Result;

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
        return this.result;
    }

    private Node getStartingNode() {
        String lastNodeName = lastResult.get(lastResult.size()-1).getName();
        return graph.getNodeByName(lastNodeName);
    }
}
