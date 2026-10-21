public class graph_linkedList {

    private static class Node {
        private final int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private final Node[] list;
    private final int vertex;

    graph_linkedList(int vertices) {
        vertex = vertices;
        list = new Node[vertices];
    }

    // Add an edge to an undirected graph.
    void addEdge(int u, int v) {
        list[u] = new Node(v, list[u]);
        list[v] = new Node(u, list[v]);
    }

    // Display the adjacency list.
    void display() {
        System.out.println("Adjacency List");

        for (int i = 0; i < vertex; i++) {
            System.out.print(i + " -> ");

            Node current = list[i];
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println();
        }
    }

    // Depth-first traversal using recursion.
    void dfs(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");

        Node current = list[source];
        while (current != null) {
            if (!visited[current.data]) {
                dfs(current.data, visited);
            }
            current = current.next;
        }
    }

    // Breadth-first traversal using an array-backed queue.
    void bfs(int start) {
        boolean[] visited = new boolean[vertex];
        int[] queue = new int[vertex];
        int front = 0;
        int rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        System.out.print("BFS : ");

        while (front < rear) {
            int currentVertex = queue[front++];
            System.out.print(currentVertex + " ");

            Node current = list[currentVertex];
            while (current != null) {
                int neighbor = current.data;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue[rear++] = neighbor;
                }
                current = current.next;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        graph_linkedList graph = new graph_linkedList(6);

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
