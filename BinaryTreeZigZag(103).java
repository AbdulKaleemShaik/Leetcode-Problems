import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curlevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    TreeNode curnode = queue.pollFirst();
                    curlevel.add(curnode.val);
                    if (curnode.left != null) {
                        queue.addLast(curnode.left);
                    }
                    if (curnode.right != null) {
                        queue.addLast(curnode.right);
                    }
                } else {
                    TreeNode curnode = queue.pollLast();
                    curlevel.add(curnode.val);
                    if (curnode.right != null) {
                        queue.addFirst(curnode.right);
                    }
                    if (curnode.left != null) {
                        queue.addFirst(curnode.left);
                    }
                }

            }
            reverse = !reverse;
            result.add(curlevel);
        }

        return result;
    }
}