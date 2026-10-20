import java.util.ArrayList;
import java.util.List;

public class SegmentTree {

    private final int size;
    private final long[] treeSum;
    private final long[] treeMin;
    private final long[] treeMax;
    private final long[] lazy;

    public SegmentTree(BinaryTree.Node root) {
        List<Long> values = new ArrayList<>();
        collectPreorder(root, values);
        size = values.size();

        int capacity = Math.max(1, 4 * size);
        treeSum = new long[capacity];
        treeMin = new long[capacity];
        treeMax = new long[capacity];
        lazy = new long[capacity];

        if (size > 0) {
            long[] items = new long[size];
            for (int i = 0; i < size; i++) {
                items[i] = values.get(i);
            }
            build(items, 1, 0, size - 1);
        }
    }

    private void collectPreorder(BinaryTree.Node node, List<Long> values) {
        if (node == null) {
            return;
        }
        values.add((long) node.data);
        collectPreorder(node.left, values);
        collectPreorder(node.right, values);
    }

    private void build(long[] values, int node, int start, int end) {
        if (start == end) {
            treeSum[node] = values[start];
            treeMin[node] = values[start];
            treeMax[node] = values[start];
            return;
        }

        int mid = start + (end - start) / 2;
        build(values, node * 2, start, mid);
        build(values, node * 2 + 1, mid + 1, end);
        pull(node);
    }

    private void pull(int node) {
        treeSum[node] = treeSum[node * 2] + treeSum[node * 2 + 1];
        treeMin[node] = Math.min(treeMin[node * 2], treeMin[node * 2 + 1]);
        treeMax[node] = Math.max(treeMax[node * 2], treeMax[node * 2 + 1]);
    }

    private void applyLazy(int node, int start, int end, long value) {
        treeSum[node] += (end - start + 1L) * value;
        treeMin[node] += value;
        treeMax[node] += value;
        lazy[node] += value;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        applyLazy(node * 2, start, mid, lazy[node]);
        applyLazy(node * 2 + 1, mid + 1, end, lazy[node]);
        lazy[node] = 0;
    }

    public long querySum(int left, int right) {
        validateRange(left, right);
        return querySum(1, 0, size - 1, left, right);
    }

    private long querySum(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }
        if (left <= start && end <= right) {
            return treeSum[node];
        }

        push(node, start, end);
        int mid = start + (end - start) / 2;
        return querySum(node * 2, start, mid, left, right)
                + querySum(node * 2 + 1, mid + 1, end, left, right);
    }

    public long queryMin(int left, int right) {
        validateRange(left, right);
        return queryMin(1, 0, size - 1, left, right);
    }

    private long queryMin(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return treeMin[node];
        }

        push(node, start, end);
        int mid = start + (end - start) / 2;
        return Math.min(
                queryMin(node * 2, start, mid, left, right),
                queryMin(node * 2 + 1, mid + 1, end, left, right));
    }

    public long queryMax(int left, int right) {
        validateRange(left, right);
        return queryMax(1, 0, size - 1, left, right);
    }

    private long queryMax(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return Long.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return treeMax[node];
        }

        push(node, start, end);
        int mid = start + (end - start) / 2;
        return Math.max(
                queryMax(node * 2, start, mid, left, right),
                queryMax(node * 2 + 1, mid + 1, end, left, right));
    }

    public void rangeUpdate(int left, int right, long value) {
        validateRange(left, right);
        rangeUpdate(1, 0, size - 1, left, right, value);
    }

    private void rangeUpdate(int node, int start, int end, int left, int right, long value) {
        if (right < start || left > end) {
            return;
        }
        if (left <= start && end <= right) {
            applyLazy(node, start, end, value);
            return;
        }

        push(node, start, end);
        int mid = start + (end - start) / 2;
        rangeUpdate(node * 2, start, mid, left, right, value);
        rangeUpdate(node * 2 + 1, mid + 1, end, left, right, value);
        pull(node);
    }

    private void validateRange(int left, int right) {
        if (left < 0 || right < left || right >= size) {
            throw new IndexOutOfBoundsException(
                    "Range [" + left + ", " + right + "] is invalid for size " + size);
        }
    }

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(10);
        root.left = new BinaryTree.Node(20);
        root.left.left = new BinaryTree.Node(40);
        root.left.right = new BinaryTree.Node(50);
        root.left.right.right = new BinaryTree.Node(91);
        root.left.right.right.right = new BinaryTree.Node(68);
        root.right = new BinaryTree.Node(30);

        SegmentTree segmentTree = new SegmentTree(root);

        System.out.println("Segment Tree Sum = " + segmentTree.querySum(0, 6));
        System.out.println("Segment Tree Min = " + segmentTree.queryMin(0, 6));
        System.out.println("Segment Tree Max = " + segmentTree.queryMax(0, 6));
        System.out.println("Range Sum (1 to 3) = " + segmentTree.querySum(1, 3));
        System.out.println("Range Min (1 to 3) = " + segmentTree.queryMin(1, 3));
        System.out.println("Range Max (1 to 3) = " + segmentTree.queryMax(1, 3));

        segmentTree.rangeUpdate(1, 3, 80);
        System.out.println("After range update (1 to 3, +80):");
        System.out.println("Segment Tree Sum = " + segmentTree.querySum(0, 6));
        System.out.println("Segment Tree Min = " + segmentTree.queryMin(0, 6));
        System.out.println("Segment Tree Max = " + segmentTree.queryMax(0, 6));
        System.out.println("Updated Range Sum (1 to 3) = " + segmentTree.querySum(1, 3));
    }
}
