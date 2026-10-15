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
            return false; // Cycle formed
        }

        if (parent[rootA] > parent[rootB]) {
          System.out.println("HI");
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootA] = parent[rootA] + parent[rootB];
        parent[rootB] = rootA;

        return true;
    }

    public static void main(String[] args) {
        initialize();

        int[][] edges = {
            {1, 2},
            {2,3},
            {7,1},
            {3, 4},
           // {4, 3},
            {5, 6},
            {7, 8},
            {2,4},
            // {2,7},
            {4,7}
        };

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                System.out.println(
                    "Cycle formed at edge: "
                    + edge[0] + " - " + edge[1]
                );
                return;
            }
        }

        System.out.println("No cycle");

        System.out.println("Parent array:");
        for (int i = 1; i <= 8; i++) {
            System.out.print(parent[i] + " ");
        }
    }
}