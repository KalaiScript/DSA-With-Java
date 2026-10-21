import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_arraylist {

    private final ArrayList<ArrayList<Integer>> list;
    private final int vertex;

    Graph_arraylist(int vertices) {
        vertex = vertices;
        list = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            list.add(new ArrayList<>());
        }
    }

    // Add an edge to an undirected graph.
    void addEdge(int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    // Display the adjacency list.
    void display() {
        System.out.println("Adjacency List");

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + " -> ");

            for (int neighbor : list.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    // Breadth-first traversal using a queue.
    void bfs(int start) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS : ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : list.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // Depth-first traversal using recursion.
    void dfs(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : list.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph_arraylist graph = new Graph_arraylist(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        graph.display();
        System.out.println();

        System.out.print("DFS : ");
        graph.dfs(0, new boolean[6]);
        System.out.println();

        graph.bfs(0);
    }
}
