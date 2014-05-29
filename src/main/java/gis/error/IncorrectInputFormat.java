package gis.error;

/**
 * Exception thrown when given input graph is in incorrect format.
 */
public class IncorrectInputFormat extends Exception {
	private static final long serialVersionUID = 7365677947004147814L;

	public IncorrectInputFormat(String message) {
        super("Incorrect input format: " + message);
    }
}
