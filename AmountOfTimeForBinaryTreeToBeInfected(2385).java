import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

 class amount {
    public static int amountOfTime(TreeNode root, int start) {
        int time = 0;
        HashMap<TreeNode, TreeNode> hs = new HashMap<>();
        TreeNode startingpoint = maptoparent(root, start, hs);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.add(startingpoint);
        set.add(startingpoint);
        while (!q.isEmpty()) {
            int len = q.size();
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && !set.contains(curr.left)) {
                    flag = true;
                    q.add(curr.left);
                    set.add(curr.left);

                }
                if (curr.right != null && !set.contains(curr.right)) {
                    flag = true;
                    q.add(curr.right);
                    set.add(curr.right);
                }
                if (hs.containsKey(curr) && !set.contains(hs.get(curr))) {
                    q.add(hs.get(curr));
                    set.add(hs.get(curr));
                    flag = true;
                }
            }
            if (flag) {
                time++;
            }
        }
        return time;

    }

    public static TreeNode maptoparent(TreeNode root, int s, HashMap<TreeNode, TreeNode> hs) {
        TreeNode start = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == s) {
                start = curr;
            }
            if (curr.left != null) {
                hs.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                hs.put(curr.right, curr);
                q.add(curr.right);
            }

        }
        return start;
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
