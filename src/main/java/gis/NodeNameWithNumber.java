package gis;

/**
 * Helper class to store Node along with a number
 */
public class NodeNameWithNumber {
    private final String name;
    private final int number;

    public NodeNameWithNumber(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
