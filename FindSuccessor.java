import java.util.LinkedList;
import java.util.Queue;

public class FindSuccessor {

}

class Solution {
    public TreeNode FindSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;

        }
        Queue<TreeNode> qr = new LinkedList<>();
        qr.add(root);
        while (!qr.isEmpty()) {
            int size = qr.size();
            TreeNode curnode = qr.poll();
            if (curnode.left != null) {
                qr.add(curnode.left);
            }
            if (curnode.right != null) {
                qr.add(curnode.right);
            }

            if (curnode.val == key) {
                break;
            }

        }

        return qr.peek();
    }
}