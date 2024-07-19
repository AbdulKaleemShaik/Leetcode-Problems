import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt = 0;
 
     public int countPairs(TreeNode root, int distance) {
         dfs(root, distance);
         return cnt;
     }
 
     private List<Integer> dfs(TreeNode root, int distance) {
         if (root == null) {
             return new ArrayList<>();
         }
         List<Integer> lefIntegers = dfs(root.left, distance);
         List<Integer> righIntegers = dfs(root.right, distance);
         if (lefIntegers.size() == 0 && righIntegers.size() == 0) {
             List<Integer> temp = new ArrayList<>();
             temp.add(1);
             return temp;
         }
         for (Integer i : lefIntegers) {
             for (Integer j : righIntegers) {
                 if ( i + j <= distance)
                     cnt++;
             }
         }
         List<Integer> temp = new ArrayList<>();
         for (int i : lefIntegers) {
                 temp.add(i + 1);
         }
         for (int i : righIntegers) {
                 temp.add(i + 1);
         }
         return temp;
     }
 }