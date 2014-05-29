package gis.lbfs;

import gis.Graph;
import gis.Node;
import gis.Result;
import gis.ResultWithNeighbours;

import java.util.ArrayList;
import java.util.List;

public class Star extends GeneralProcedure implements LBFS {
    private Result sigmaPlus;
    private Result sigmaPlusPlus;
    private Result iPlus;
    private Result iPlusPlus;
    private ResultWithNeighbours aNbrs;
    private ResultWithNeighbours bNbrs;

    public Star(Graph graph, Result sigmaPlus, Result sigmaPlusPlus, Result iPlus, Result iPlusPlus, ResultWithNeighbours aNbrs, ResultWithNeighbours bNbrs) {
        super(graph);
        this.sigmaPlus = sigmaPlus;
        this.sigmaPlusPlus = sigmaPlusPlus;
        this.iPlus = iPlus;
        this.iPlusPlus = iPlusPlus;
        this.aNbrs = aNbrs;
        this.bNbrs = bNbrs;
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

    @Override
    public Node selectInCaseOfTie(ArrayList<Node> l) {
        Node max;

        String name = sigmaPlus.getNodeWithMinNumber(l);
        Node a = graph.getNodeByName(name);
        name = sigmaPlusPlus.getNodeWithMinNumber(l);
        Node b = graph.getNodeByName(name);
        /*
        * Apply the rules defined above and select a node
        */
        max = select(a, b);

        return max;
    }


    @Override
    public Node getStartingNode() {
        String name = sigmaPlus.get(sigmaPlus.size()-1).getName();
        Node a = graph.getNodeByName(name);
        name = sigmaPlusPlus.get(sigmaPlusPlus.size()-1).getName();
        Node b = graph.getNodeByName(name);
        return select(a, b);
    }

    /**
     * <pre>
     * Select out of the two nodes a, from sigma+, and b, from sigma++,
     * according to the following rules:
     *
     * (a) if i+(a) > sigma+(a), CHOOSE b.
     * (b) if i++(b) > sigma++(b), CHOOSE a.
     * (c) if |B(b)| = 0 OR |A(a)| != 0, CHOOSE b.
     * (d) Let y be an arbitrary element of B(b). If i+(y) = sigma+(a),
     *     then CHOOSE b, else CHOOSE a.
     *
     * where
     * i+      := I_PLUS
     * i++     := I_PLUS_PLUS
     * sgima+  := SIGMA_PLUS
     * sigma++ := SIGMA_PLUS_PLUS
     * A       := A_NBRS
     * B       := B_NBRS
     * </pre>
     *
     * @param a Last selected Node from sigma+
     * @param b Last selected Node from sigma++
     * @return Node selected after applying the above defined rules
     */
    public Node select(Node a, Node b)
    {
        Node selected = null;
        if (a.getName().equals(b.getName()))
            return a;
        String aName = a.getName();
        String bName = b.getName();
        if (iPlus.getByName(aName) > sigmaPlus.getByName(aName))
            selected = b;
        else if (iPlusPlus.getByName(bName) > sigmaPlusPlus.getByName(bName))
            selected = a;
        else if (bNbrs.getByName(bName) == 0 || aNbrs.getByName(aName) != 0)
            selected = b;
        else
        {
            String random = bNbrs.getRandom();
            if (iPlus.getByName(random) == sigmaPlus.getByName(aName))
                selected = b;
            else
                selected = a;
        }
        return selected;
    }
}
