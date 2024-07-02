class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        if (root == null) {
            return 0;
        }

        SubtreeInfo result = largestBSTSubtree(root);
        return result.size;
    }

    private static SubtreeInfo largestBSTSubtree(Node node) {
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        SubtreeInfo leftInfo = largestBSTSubtree(node.left);
        SubtreeInfo rightInfo = largestBSTSubtree(node.right);

        // Check if current node forms a BST
        if (leftInfo.isBST && rightInfo.isBST &&
                (leftInfo.max < node.data || node.left == null) &&
                (rightInfo.min > node.data || node.right == null)) {

            int size = leftInfo.size + rightInfo.size + 1;
            int min = (node.left != null) ? leftInfo.min : node.data;
            int max = (node.right != null) ? rightInfo.max : node.data;

            return new SubtreeInfo(size, min, max, true);
        } else {
            // If not a BST, return the largest BST found in left or right subtree
            int size = Math.max(leftInfo.size, rightInfo.size);
            return new SubtreeInfo(size, 0, 0, false);
        }
    }
}

class SubtreeInfo {
    int size;
    int min;
    int max;
    boolean isBST;

    SubtreeInfo(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
