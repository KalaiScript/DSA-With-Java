# Data Structures and Algorithms in Java

A collection of small Java programs for learning common data structures and algorithms. Each example includes sample data and a `main` method, so you can compile and run it directly.

The implementations favor straightforward Java code to make the underlying ideas easier to follow.

## Topics and examples

| File | What it demonstrates |
| --- | --- |
| `BinaryTree.java` | Binary-tree operations, including minimum and maximum values, leaf totals and counts, balance checks, lowest common ancestor, and iterative Fibonacci |
| `SegmentTree.java` | A segment tree built from a binary tree's preorder values; sum, minimum, and maximum range queries; lazy range updates |
| `Graphs.java` | An undirected graph using an adjacency matrix, with edge operations and DFS/BFS traversals |
| `Graph_arraylist.java` | An undirected graph using `ArrayList` adjacency lists, with DFS and BFS |
| `graph_linkedList.java` | An undirected graph using linked-list adjacency lists, with DFS and BFS |
| `Dijskra_Algorithm.java` | Dijkstra's shortest-path algorithm for a directed, weighted graph, plus directed-cycle detection |
| `TopologicalSort.java` | Topological sorting of a directed graph using DFS and Kahn's algorithm |
| `MinimumSpanTree.java` | Prim-style minimum spanning tree construction using a weighted adjacency matrix |
| `MST_Weight.java` | Kruskal's minimum spanning tree algorithm with a disjoint-set (union-find) structure |
| `Kruskal.java` | Disjoint-set operations and cycle detection in a graph |

> **Note:** `Dijskra_Algorithm.java` uses the spelling `Dijskra_Algorithm` in its filename and class name. Keep this spelling when compiling or running the example.

## Requirements

- A Java Development Kit (JDK) installed and available on your `PATH`.
- PowerShell or another terminal.

To check that Java is installed, run:

```powershell
java -version
javac -version
```

## Compile the examples

Open a terminal in the repository folder and compile the Java source files:

```powershell
javac *.java
```

The compiler creates `.class` files in the same folder.

## Run an example

Run a class by passing its name to `java` (without the `.java` extension). For example:

```powershell
java BinaryTree
```

Other available examples include:

```powershell
java SegmentTree
java Graphs
java Graph_arraylist
java graph_linkedList
java Dijskra_Algorithm
java TopologicalSort
java MinimumSpanTree
java MST_Weight
java Kruskal
```

Each program uses its own sample data and prints results to the terminal.

## Suggested learning order

1. `BinaryTree.java` — learn tree structure and recursive operations.
2. `SegmentTree.java` — explore range queries and lazy updates.
3. `Graphs.java`, `Graph_arraylist.java`, and `graph_linkedList.java` — compare graph representations and traversals.
4. `TopologicalSort.java` — understand ordering and dependencies in directed graphs.
5. `Dijskra_Algorithm.java` — study shortest paths in weighted graphs.
6. `MinimumSpanTree.java` and `MST_Weight.java` — compare Prim's and Kruskal's approaches to minimum spanning trees.
7. `Kruskal.java` — review disjoint sets and cycle detection.

## Notes

- Graph vertices are commonly numbered starting at `0`.
- The union-find examples use integer node identifiers.
- These examples are intended for learning; implementations may prioritize clarity over production-scale performance.

## Contributing

Contributions are welcome. Add a focused Java example, include sample data that makes it easy to try, and update the table above with a brief description.
