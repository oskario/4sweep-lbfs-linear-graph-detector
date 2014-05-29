package gis;

import gis.error.IncorrectInputFormat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
     * [node name] [neighbor 1] [neighbor 2] ...
     * ```
     * @param input list of lines from file
     * @return newly created Graph
     * @throws IncorrectInputFormat when given input is in incorrect format
     */
    public static Graph read(List<String> input) throws IncorrectInputFormat {
        Map<String, Node> nodes = new HashMap<String, Node>();
        
        int i = 1;
        for (String line : input) {
            String params[] = line.split(" ");
            
            if (params.length < 2) 
                throw new IncorrectInputFormat("Not enough parameters in line " + i + " (" + line + ")");
            
            
            Node node = new Node(params[0]);
            nodes.put(node.getName(), node);
            for (int j = 1; j < params.length; j++) {
                String neighbourName = params[j];

//                if (!nodes.containsKey(neighbourName)) {
//                    Node neighbour = new Node(neighbourName);
//                    nodes.put(neighbourName, neighbour);
//                }

                node.addNeighbour(neighbourName);
            }
            
            i++;
        }

        return new Graph(new LinkedList<Node>(nodes.values()));
    }
}
