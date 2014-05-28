package gis.error;

/**
 * Exception thrown when given input graph is in incorrect format.
 */
public class IncorrectInputFormat extends Exception {

    public IncorrectInputFormat(String message) {
        super("Incorrect input format: " + message);
    }
}
