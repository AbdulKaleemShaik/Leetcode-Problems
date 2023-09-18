import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightview(root, result, 0);
        return result;

    }

    public void rightview(TreeNode curr, List<Integer> result, int depth) {
        if (curr == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(curr.val);
        }
        rightview(curr.right, result, depth + 1);
        rightview(curr.left, result, depth + 1);
    }
}