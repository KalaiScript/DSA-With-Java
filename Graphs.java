
import java.util.*;

public class Graphs {

    int arr[][];
    int n;
    boolean visit[];

    Graphs(int n) {
        this.n = n;
        arr = new int[n][n];
        visit = new boolean[n];
    }

    void add(int i, int j) {
        arr[i][j] = 1;
        arr[j][i] = 1;
    }

    void displayCount() {
        System.out.println("Count vertex: " + n);
    }

    void vertex() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ---> ");

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }

            System.out.println();
        }
    }

    void remove(int i, int j) {
        arr[i][j] = 0;
        arr[j][i] = 0;
    }

    boolean isEdges(int i, int j) {
        return arr[i][j] == 1;
    }

    void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void dfs(int source, boolean visit[]) {
        System.out.print(source + " ");
        visit[source] = true;

        for (int i = 0; i < n; i++) {
            if (arr[source][i] == 1 && !visit[i]) {
                dfs(i, visit);
            }
        }
    }

    void bfs(int source) {
        int queue[] = new int[n];
        boolean bfsvisit[] = new boolean[n];
        int front = 0;
        int rear = 0;

        System.out.println("BFS function working:");

        bfsvisit[source] = true;
        queue[rear++] = source;

        while (front < rear) {
            int cur = queue[front++];
            System.out.print(cur + " ");

            for (int i = 0; i < n; i++) {
                if (arr[cur][i] == 1 && !bfsvisit[i]) {
                    bfsvisit[i] = true;
                    queue[rear++] = i;
                }
            }
        }

        System.out.println();
    }

    public static void main(String... kalai) {

        Graphs m = new Graphs(5);

        m.displayCount();

        m.add(0, 1);
        m.add(0, 2);
        m.add(0, 3);
        m.add(0, 4);
        m.add(1, 2);
        m.add(1, 4);
        m.add(3, 4);

        System.out.println("Graph length: " + m.arr[0].length);

        System.out.println("Print the graph:");
        m.display();

        System.out.println("Print each vertex and its edges:");
        m.vertex();

        System.out.println("Before removing the edge:");
        m.display();

        m.remove(1, 4);

        System.out.println("After removing the edge:");
        m.display();

        Graphs m1 = new Graphs(6);

        m1.add(0, 5);
        m1.add(1, 2);
        m1.add(2, 5);
        m1.add(1, 3);
        m1.add(1, 4);
        m1.add(0, 1);

        System.out.println("DFS function working:");
        m1.dfs(1, m1.visit);
        System.out.println();

        m1.bfs(0);
    }
}