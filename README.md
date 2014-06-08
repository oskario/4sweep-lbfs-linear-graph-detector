4-sweep LBFS linear graph detector
=================================

Application that detects whether given graph is linear using 4-sweep LBFS algorithm.

## Usage

Usage: java -jar <jar_name>.jar [-d] input_filename

Options:
-d  debug mode

### Input

Input graph is represented as a text file, in which each line contains information about the node and its neighbors:

```
[node name] [neighbour 1] [neighbour 2] ...
```

### Debug mode

In debug mode program displays detailed information about how each phase of the algorithm is being calculated.

## Output

As a result of executing it the program will tell whether given graph is interval or not by displaying corresponding line, either: 
 
``` Graph is interval ```

or 

``` Graph is not interval ```

Any errors are also be displayed with corresponding error message on the standard output.