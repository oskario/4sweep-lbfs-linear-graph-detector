package gis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Run {
    private static final String USAGE =
            "Usage: java -jar <jar_name>.jar [-d] input_filename\n" +
            "\nOptions:\n" +
            "-d\tdebug mode";

    public static void main(String[] args) {

        String filename;
        Boolean isDebugMode = false;

        if (args.length == 1) {
            filename = args[0];
        } else if (args.length == 2) {
            isDebugMode = args[0].equals("-d");
            filename = args[1];
        } else {
            System.out.println(USAGE);
            return;
        }

        try {
            List<String> input = readFile(filename);
            Graph graph = GraphReader.read(input);

            if (graph.isInterval(isDebugMode))
                System.out.println("Graph is interval");
            else
                System.out.println("Graph is not interval");

        } catch (FileNotFoundException e) {
            System.err.format("File '%s' was not found", filename);

        } catch (IOException e) {
            System.err.format("IOException while trying to read '%s'", filename);
            e.printStackTrace();

        } catch (Exception e) {
            System.err.format("Unknown exception occurred: %s", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Reads file line by line to list of strings.
     *
     * @param filename target filename
     * @return list of lines
     * @throws IOException
     */
    private static List<String> readFile(String filename) throws IOException {
        List<String> records = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            records.add(line);
        }

        reader.close();
        return records;
    }
}
