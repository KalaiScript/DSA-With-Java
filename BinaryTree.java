public class BinaryTree {

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    static int minValue(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minValue(root.left);
        int rightMin = minValue(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    static int maxValue(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = maxValue(root.left);
        int rightMax = maxValue(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    int leafsum(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        return leafsum(root.left) + leafsum(root.right);
    }

    int leafcount(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafcount(root.left) + leafcount(root.right);
    }

    static int fib_dp(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n < 2) {
            return n;
        }

        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = Math.addExact(previous, current);
            previous = current;
            current = next;
        }
        return current;
    }

    boolean isBalance(Node root) {
        return checkH(root) != -1;
    }

    private int checkH(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkH(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkH(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    Node lowestCommonAncestor(int n1, int n2) {
        if (!contains(root, n1) || !contains(root, n2)) {
            return null;
        }
        return lcaH(root, n1, n2);
    }

    private Node lcaH(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lcaH(root.left, n1, n2);
        Node right = lcaH(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    private boolean contains(Node root, int value) {
        return root != null
                && (root.data == value || contains(root.left, value) || contains(root.right, value));
    }

    public static void main(String... args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.left.right.right = new Node(91);
        tree.root.left.right.right.right = new Node(68);
        tree.root.right = new Node(30);

        System.out.println("Minimum value: " + minValue(tree.root));
        System.out.println("Maximum value: " + maxValue(tree.root));
        System.out.println("Leaf sum: " + tree.leafsum(tree.root));
        System.out.println("Leaf count: " + tree.leafcount(tree.root));
        System.out.println("Balanced: " + tree.isBalance(tree.root));
        Node ancestor = tree.lowestCommonAncestor(40, 50);
        System.out.println("LCA of 40 and 50: " + (ancestor == null ? "Not found" : ancestor.data));
        System.out.println("Fibonacci(10): " + fib_dp(10));
    }
}
