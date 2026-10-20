# DSA With Java

This repository is a hands-on Java practice set for learning core data structures and algorithms. Each file contains a small, self-contained program with a `main` method and sample input, making it easy to compile and run examples directly in Java.

The goal is to help beginners understand how common DSA concepts work in code, not just memorize theory. Each implementation focuses on clarity and correctness, using simple arrays, matrices, recursion, and custom classes instead of advanced libraries.

## What is included

This repository covers:

- Binary trees and recursive tree operations
- Graph representations and graph traversal
- Shortest-path algorithms
- Topological sorting
- Minimum spanning tree algorithms
- Disjoint-set / union-find concepts
- Cycle detection in graphs and sets

## Project files and full descriptions

### 1) `BinaryTree.java`

This file implements a binary tree and demonstrates several important tree operations.

Key concepts covered:

- Tree node creation with left and right child pointers
- Finding the minimum and maximum value in a tree
- Summing values present in leaf nodes
- Counting the number of leaf nodes
- Checking whether the tree is balanced
- Finding the lowest common ancestor (LCA) of two nodes
- Computing Fibonacci numbers using an iterative dynamic-programming approach

This example is useful for learning how recursion works on hierarchical data structures and how tree problems can be reduced into smaller subproblems.

### 2) `Graphs.java`

This file builds an undirected, unweighted graph using an adjacency matrix.

Key concepts covered:

- Graph initialization with a matrix representation
- Adding and removing edges
- Checking whether an edge exists between two vertices
- Displaying the adjacency matrix and adjacency list style output
- Depth-first traversal (DFS)
- Breadth-first traversal (BFS)
- Graph counting and vertex display operations

This is a great beginner-friendly graph example because the adjacency matrix is easy to visualize and understand before moving to more complex graph representations.

### 3) `Dijskra_Algorithm.java`

This file demonstrates Dijkstra's shortest-path algorithm on a directed weighted graph.

Key concepts covered:

- Weighted graph representation using a 2D matrix
- Adding directed edges with associated weights
- Finding the shortest distance from a selected source vertex
- Visiting the nearest unvisited node repeatedly
- Relaxing edges to update shortest distances
- Cycle detection in a directed graph using DFS

The class name is spelled `Dijskra_Algorithm` intentionally to match the file name and to preserve the original project naming. The example also includes a helper `GraphMatrix` class.

This program helps learners see how shortest-path problems are solved in weighted graphs and how greedy choices work in Dijkstra's algorithm.

### 4) `TopologicalSort.java`

This file shows a directed graph and demonstrates topological sorting.

Key concepts covered:

- Directed graph using adjacency matrix
- Checking whether an edge exists between two vertices
- Displaying vertices and adjacency information
- DFS-based ordering
- BFS-based traversal
- In-degree counting for each node
- Kahn's algorithm for topological sort
- Detecting cycles when a valid topological ordering is impossible

Topological sorting is used in scheduling, dependency resolution, and task ordering. This example is especially useful for understanding how nodes with no incoming dependency can be processed first.

### 5) `MinimumSpanTree.java`

This file implements a Prim-style minimum spanning tree (MST) solution using a weighted adjacency matrix.

Key concepts covered:

- Weighted graph creation
- Selecting the smallest edge that connects visited and unvisited vertices
- Growing a spanning tree incrementally
- Tracking total MST weight
- Detecting disconnected graphs

A minimum spanning tree connects all vertices with the least total edge weight while avoiding cycles. This example demonstrates the greedy strategy behind Prim's algorithm.

### 6) `MST_Weight.java`

This file implements Kruskal's algorithm with a disjoint-set (union-find) structure.

Key concepts covered:

- Disjoint-set initialization
- Parent tracking and path compression
- Union operation for connecting components
- Cycle detection during edge processing
- Sorting edges by weight
- Selecting a minimum spanning tree for a weighted graph
- Calculating the total cost of the MST

Kruskal's algorithm is another classic MST approach. Instead of growing a tree from one source vertex, it processes edges by increasing weight and adds those that do not form cycles.

### 7) `Kruskal.java`

This file is a simpler disjoint-set example that focuses on detecting cycles while processing edges.

Key concepts covered:

- Parent array representation of disjoint sets
- Finding the root of a node
- Union of two sets
- Detecting when an edge connects vertices already in the same set
- Identifying a cycle in a graph

This is a compact and beginner-friendly introduction to the union-find data structure, which is foundational for Kruskal's MST algorithm.

## Requirements

- Java Development Kit (JDK) installed and available on your `PATH`
- A terminal or command prompt to compile and run Java files

## Compile all programs

From the repository root, run:

```powershell
javac *.java
```

This will compile all Java source files in the folder into `.class` files.

## Run an example

After compilation, run any class with:

```powershell
java BinaryTree
java Graphs
java Dijskra_Algorithm
java TopologicalSort
java MinimumSpanTree
java MST_Weight
java Kruskal
```

Each program contains its own sample dataset and prints output to demonstrate the concept being implemented.

## Notes

- The graph examples use zero-based indexing for vertices in many cases.
- The union-find examples operate on integer node IDs and are easier to follow when seen as small graph structures.
- Some files are intentionally simple so the underlying algorithm is easier to understand.

## Learning path

A suggested order for studying these examples is:

1. `BinaryTree.java` — understand recursion and tree structure
2. `Graphs.java` — understand graph representation and traversal
3. `TopologicalSort.java` — learn directed graph dependencies
4. `Dijskra_Algorithm.java` — understand weighted shortest paths
5. `MinimumSpanTree.java` and `MST_Weight.java` — learn spanning tree algorithms
6. `Kruskal.java` — understand union-find in isolation

## Contributing

To contribute, add new Java examples that teach a specific algorithm or data structure clearly, and update this README to document the new program and its purpose.
