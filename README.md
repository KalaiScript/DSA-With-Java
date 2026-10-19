# DSA With Java

A collection of beginner-friendly Java examples for learning data structures and algorithms. Each program includes a `main` method with sample data so you can compile and run the examples directly.

## Contents

### Trees

- `BinaryTree.java` — minimum and maximum values, leaf sum and count, balance checking, lowest common ancestor, and an iterative Fibonacci example.

### Graphs

- `Graphs.java` — an undirected, unweighted graph using an adjacency matrix, with edge management and DFS/BFS traversals.
- `Dijskra_Algorithm.java` — a directed, weighted graph with Dijkstra's shortest-path algorithm and directed-cycle detection. The file and class use the spelling `Dijskra_Algorithm`.
- `TopologicalSort.java` — a directed graph with adjacency-matrix operations, traversals, in-degree counting, and Kahn's topological sort with cycle detection.

### Minimum spanning trees and disjoint sets

- `MinimumSpanTree.java` — a Prim-style minimum spanning tree example using a weighted adjacency matrix.
- `MST_Weight.java` — Kruskal's algorithm with a disjoint-set structure, path compression, and union by size.
- `Kruskal.java` — a disjoint-set example that detects a cycle while processing edges.

## Requirements

- Java Development Kit (JDK) installed and available on your `PATH`.

## Compile

From the repository directory, compile all Java source files:

```powershell
javac *.java
```

## Run an example

Run a compiled class by its name, without the `.java` extension:

```powershell
java BinaryTree
java Graphs
java Dijskra_Algorithm
java TopologicalSort
java MinimumSpanTree
java MST_Weight
java Kruskal
```

Each command runs that class's built-in sample program. Some graph routines accept vertex numbers that must be valid indices for the graph; the examples use zero-based indices except for the disjoint-set examples.

## Contributing

Add new examples as Java source files, and update this README when the repository's contents or run instructions change.
