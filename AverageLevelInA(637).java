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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> qr = new LinkedList<>();
        qr.add(root);
        while (!qr.isEmpty()) {
            int size = qr.size();
            double averagelevel = 0;
            List<Integer> curlevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curnode = qr.poll();
                averagelevel += curnode.val;
                if (curnode.left != null) {
                    qr.add(curnode.left);
                }
                if (curnode.right != null) {
                    qr.add(curnode.right);
                }
            }

            result.add(averagelevel / size);

        }

        return result;
    }
}