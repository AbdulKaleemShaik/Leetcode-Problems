import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
                if (i == size - 1) {
                    result.add(curnode.val);
                }

                if (curnode.left != null) {
                    qr.add(curnode.left);
                }
                if (curnode.right != null) {
                    qr.add(curnode.right);
                }
            }

        }

        return result;
    }
}