import java.util.Arrays;

public class Kruskal {

    static int[] parent = new int[9];

    static void initialize() {
        Arrays.fill(parent, -1);
    }

    static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (parent[rootA] > parent[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootA] = parent[rootA] + parent[rootB];
        parent[rootB] = rootA;
        return true;
    }

    static void kruskal(int[][] edges) {
        initialize();

        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                if (edges[i][2] > edges[j][2]) {
                    int[] temp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = temp;
                }
            }
        }

        int edgeCount = 0;
        int totalWeight = 0;

        System.out.println("Edges in the minimum spanning forest:");
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                System.out.println(edge[0] + " - " + edge[1] + " : " + edge[2]);
                totalWeight += edge[2];
                edgeCount++;
            }
        }

        System.out.println("Total weight: " + totalWeight);
        if (edgeCount != 7) {
            System.out.println("Graph is disconnected; a minimum spanning tree does not exist.");
        }

        System.out.println("Parent array:");
        for (int i = 1; i <= 8; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] edges = {
            {1, 2, 4},
            {2, 3, 2},
            {7, 1, 3},
            {3, 4, 6},
            {5, 6, 1},
            {7, 8, 5},
            {2, 4, 3},
            {4, 7, 7}
        };

        kruskal(edges);
    }
}
