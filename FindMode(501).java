import java.util.HashMap;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
 this.val = val;
  this.left = left;
  this.right = right;
  }
  }
 
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        int max = Integer.MIN_VALUE;
        for (var i : map.values()) {
            max = Math.max(max, i);
        }
        int n = 0;
        for (var j : map.values()) {
            if (j == max) {
                n++;
            }
        }
        int[] arr = new int[n];
        int i = 0;
        for (var k : map.keySet()) {
            if (map.get(k) == max) {
                arr[i++] = k;
            }
        }
        return arr;

    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.left);
        helper(root.right);
    }
}