import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public TreeNode replaceValueInTree(TreeNode root) {
         List<Integer> levelSum = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         while (!q.isEmpty()) {
             int size = q.size();
             int currSum = 0;
             while (size-- != 0) {
                 TreeNode currNode = q.poll();
                 currSum += currNode.val;
                 if (currNode.left != null)
                     q.add(currNode.left);
                 if (currNode.right != null)
                     q.add(currNode.right);
             }
             levelSum.add(currSum);
         }
         Queue<pair> pq = new LinkedList<>();
         int level = 0;
         pq.add(new pair(root, root.val));
         while (!pq.isEmpty()) {
             int size = pq.size();
             while (size-- != 0) {
                 pair currNode = pq.poll();
                 int childCurrSum = 0;
                 TreeNode curr = currNode.node;
 
                 curr.val = levelSum.get(level) - currNode.childSum;
 
                 if (curr.left != null)
                     childCurrSum += curr.left.val;
                 if (curr.right != null)
                     childCurrSum += curr.right.val;
 
                 if (curr.left != null)
                     pq.add(new pair(curr.left, childCurrSum));
 
                 if (curr.right != null)
                     pq.add(new pair(curr.right, childCurrSum));
             }
             level++;
 
         }
         return root;
 
     }
 }
 
 class pair {
     TreeNode node;
     int childSum = 0;
 
     pair(TreeNode i, int j) {
         this.node = i;
         this.childSum = j;
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