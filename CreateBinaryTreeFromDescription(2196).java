import java.util.HashMap;
import java.util.Map;

public class createBinary {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int direction = descriptions[i][2];
            TreeNode children = null;
            TreeNode par = null;
            children = !map.containsKey(child) ? new TreeNode(child) : map.get(child);
            if (!map.containsKey(parent)) {
                par = new TreeNode(parent);
                map.put(parent, par);
            } else {
                par = map.get(parent);
            }
            if (direction == 1) {
                par.left = children;
            } else {
                par.right = children;
            }
            map.put(child, children);
        }
        TreeNode root = null;
        for (int i = 0; i < descriptions.length; i++) {
            if (map.containsKey(descriptions[i][1]))
                map.remove(descriptions[i][1]);
        }
        for (Integer i : map.keySet())
            root = map.get(i);
        return root;
    }

    public void printData(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printData(root.left);
        printData(root.right);
    }

    public static void main(String[] args) {
        createBinary cr = new createBinary();
        TreeNode root = cr.createBinaryTree(
                new int[][] { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } });
        cr.printData(root);
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
