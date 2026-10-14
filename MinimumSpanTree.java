public class MinimumSpanTree {
    int n;
    int[][] mat;
    boolean[] visit;

    MinimumSpanTree(int n) {
        this.n = n;
        mat = new int[n][n];
        visit = new boolean[n];
    }

    void add(int i, int j, int k) {
        mat[i][j] = k;
        mat[j][i] = k;
    }

    void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    void minimum_ST(int vertex, int count, int sum) {
        visit[vertex] = true;
        count++;

        if (count == n) {
            System.out.println("SUM : " + sum);
            return;
        }

        int from = -1;
        int to = -1;
        int edgeMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                for (int j = 0; j < n; j++) {
                    if (!visit[j] && mat[i][j] != 0 && mat[i][j] < edgeMin) {
                        edgeMin = mat[i][j];
                        from = i;
                        to = j;
                    }
                }
            }
        }

        if (to == -1) {
            System.out.println("Graph is disconnected");
            return;
        }

        System.out.println(from + " -> " + to + " : " + edgeMin);
        minimum_ST(to, count, sum + edgeMin);
    }

    public static void main(String... args) {
        MinimumSpanTree graph = new MinimumSpanTree(6);

        graph.add(0, 1, 2);
        graph.add(0, 5, 4);
        graph.add(0, 4, 5);

        graph.add(1, 5, 2);
        graph.add(1, 2, 5);

        graph.add(5, 2, 2);
        graph.add(5, 4, 6);

        graph.add(2, 3, 2);

        graph.add(3, 5, 1);
        graph.add(3, 4, 3);

        System.out.println("Matrix value : ");
        graph.display();

        System.out.println("Weight of each vertex : ");
        graph.minimum_ST(0, 0, 0);
    }
}
