import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

class SmallestStrng {
    public static String smallestFreaf(TreeNode root) {
        if (root == null) {
            return " ";
        }
        List<String> li = new ArrayList<>();
        find(root, "", li);
        Collections.sort(li);
        return li.get(0);
    }

    public static void find(TreeNode root, String ans, List<String> li) {
        if (root.left == null && root.right == null) {
            ans = (char) (root.val + 97) + ans;
            li.add(ans);
            return;
        }
        ans = (char) (root.val + 97) + ans;
        if (root.left != null)
            find(root.left, ans, li);
        if (root.right != null)
            find(root.right, ans, li);

    }
}