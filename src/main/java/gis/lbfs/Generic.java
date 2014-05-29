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
        Node startingNode = getRandomNode();
        startingNode.addLabel(graph.size());
        run(startingNode);
        return this.result;
    }

    private Node getRandomNode() {
        int random = new Random().nextInt(graph.size());
        return graph.getNodes().get(random);
    }


}
