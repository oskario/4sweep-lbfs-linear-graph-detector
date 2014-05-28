package gis;

import gis.error.IncorrectInputFormat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Takes care of reading the graph from the input file.
 */
public class GraphReader {

    /**
     * Creates graph based on given input string.
     *
     * Input format:
     * ```
     * [node name] [neighbour 1] [neighbour 2] ...
     * ```
     * @param input input string
     * @return newly created Graph
     * @throws IncorrectInputFormat when given input is in incorrect format
     */
    public static Graph read(String input) throws IncorrectInputFormat {
        String lines[] = input.split("\n");
        Map<String, Node> nodes = new HashMap<String, Node>();

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String params[] = line.split(" ");

            if (params.length < 2)
                throw new IncorrectInputFormat("Not enough parameters in line " + i + " (" + line + ")");

            Node node = new Node(params[0]);

            for (int j = 1; j < params.length; j++) {
                String neighbourName = params[j];

                if (!nodes.containsKey(neighbourName)) {
                    Node neighbour = new Node(neighbourName);
                    nodes.put(neighbourName, neighbour);
                }

                node.addNeighbour(nodes.get(neighbourName));
            }
        }

        return new Graph(new LinkedList<Node>(nodes.values()));
    }
}
