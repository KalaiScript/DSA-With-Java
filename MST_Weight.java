public class MST_Weight {

	int[] parent = new int[9];

	void initialize() {
		for (int i = 0; i < 9; i++) {
			parent[i] = -1;
		}
	}

	int find(int x) {
		if (parent[x] < 0) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}

	boolean union(int a, int b) {
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

	void run() {
		initialize();

		// {u, v, weight}
		int[][] edges = {
				{ 1, 2, 4 },
				{ 3, 4, 2 },
				{ 5, 6, 1 },
				{ 7, 8, 3 },
				{ 2, 3, 5 },
				{ 4, 5, 6 },
				{ 6, 7, 7 },
				{ 2, 4, 9 }
		};

		// Sort by weight using bubble sort...
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = 0; j < edges.length - 1 - i; j++) {
				if (edges[j][2] > edges[j + 1][2]) {
					int[] temp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = temp;
				}
			}
		}

		int total = 0;
		int selected = 0;

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int weight = edge[2];

			if (union(u, v)) {
				System.out.println(u + " - " + v + " : " + weight);
				total += weight;
				selected++;
				if (selected == 7) {
					break;
				}
			} else {
				System.out.println("Cycle, skipped: " + u + " - " + v + " : " + weight);
			}
		}

		System.out.println("Total MST Weight: " + total);
	}

	public static void main(String[] args) {
		System.out.println("Program started...");
		MST_Weight obj = new MST_Weight();
		obj.run();
	}
}
