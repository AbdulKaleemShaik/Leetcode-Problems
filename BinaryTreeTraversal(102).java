
// Definition for a binary tree node.

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> qr = new LinkedList<>();
        qr.add(root);
        while (!qr.isEmpty()) {
            int size = qr.size();
            List<Integer> curlevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curnode = qr.poll();
                curlevel.add(curnode.val);
                if (curnode.left != null) {
                    qr.add(curnode.left);
                }
                if (curnode.right != null) {
                    qr.add(curnode.right);
                }
            }
            result.add(curlevel);

        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}