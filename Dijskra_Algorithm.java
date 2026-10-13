import java.util.Arrays;

class GraphMatrix {

    int[][] matrix;
    int vertex;

    GraphMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    void add(int u, int v, int weight) {
        matrix[u][v] = weight;
    }

    void display() {
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void dijkstra(int source) {
        int[] distance = new int[vertex];
        boolean[] visited = new boolean[vertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int count = 0; count < vertex; count++) {
            int current = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < vertex; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    current = i;
                }
            }

            if (current == -1) {
                break;
            }

            visited[current] = true;
            for (int i = 0; i < vertex; i++) {
                if (matrix[current][i] > 0 && !visited[i]) {
                    int newDist = distance[current] + matrix[current][i];
                    if (newDist < distance[i]) {
                        distance[i] = newDist;
                    }
                }
            }
        }

        System.out.println("Shortest distances from " + vertexLabel(source) + ":");
        for (int i = 0; i < vertex; i++) {
            System.out.println(vertexLabel(i) + " = "
                    + (distance[i] == Integer.MAX_VALUE ? "Unreachable" : distance[i]));
        }
    }

    boolean cycleDFS(int current, boolean[] visited, boolean[] path) {
        visited[current] = true;
        path[current] = true;

        for (int i = 0; i < vertex; i++) {
            if (matrix[current][i] > 0) {
                if (!visited[i]) {
                    if (cycleDFS(i, visited, path)) {
                        return true;
                    }
                } else if (path[i]) {
                    return true;
                }
            }
        }

        path[current] = false;
        return false;
    }

    boolean hasCycle() {
        boolean[] visited = new boolean[vertex];
        boolean[] path = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && cycleDFS(i, visited, path)) {
                return true;
            }
        }
        return false;
    }

    private char vertexLabel(int index) {
        return index < 5 ? (char) ('A' + index) : (char) ('H' + index - 5);
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(6);

        g.add(0, 1, 2); // A -> B, weight 2
        g.add(0, 5, 4); // A -> H, weight 4
        g.add(0, 4, 5); // A -> E, weight 5

        g.add(1, 5, 2); // B -> H, weight 2
        g.add(1, 2, 5); // B -> C, weight 5

        g.add(5, 2, 2); // H -> C, weight 2
        g.add(5, 4, 6); // H -> E, weight 6

        g.add(2, 3, 2); // C -> D, weight 2

        g.add(3, 5, 1); // D -> H, weight 1
        g.add(3, 4, 3); // D -> E, weight 3

        g.dijkstra(5);
    }
}
