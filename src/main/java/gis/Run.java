package gis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Run {
	public static void main(String[] args) {
		if (args.length < 0 || args.length > 2) {
			System.out
					.println("Usage: java -jar <name_of_the_jar>.ar <filename> [<is_verbose_mode>]\n");
			return;
		}

		String filename = args[0];
        Boolean isDebugMode = getDebugMode(args);

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
			System.err
					.format("IOException while trying to read '%s'", filename);
			e.printStackTrace();

		} catch (Exception e) {
			System.err.format("Unknown exception occured: %s", e.getMessage());
			e.printStackTrace();
		}
	}

    private static Boolean getDebugMode(String[] args) {
        if (args.length == 2)
            return Boolean.parseBoolean(args[1]);
        else
            return false;
    }

    /**
	 * Reads file line by line to list of strings.
	 * 
	 * @param filename
	 *            target filename
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
