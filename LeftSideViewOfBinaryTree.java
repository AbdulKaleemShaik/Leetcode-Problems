import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class Solution {
    List<Integer> result = new ArrayList<>();
    int maxlevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        method(root, 1);
        return result;

    }

    public void method(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (maxlevel < val) {
            result.add(root.val);
            maxlevel = val;
        }
        method(root.left, val + 1);
        method(root.right, val + 1);
    }
}