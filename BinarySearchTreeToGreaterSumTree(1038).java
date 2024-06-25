public /**
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
   int sum = 0;
   int currSum = 0;

   //  private int sum = 0;
   
   // public TreeNode bstToGst(TreeNode root) {  
   //     if (root != null) {
   //         bstToGst(root.right);  
   //         sum += root.val; 
   //         root.val = sum;  
   //         bstToGst(root.left);  
   //     }
   //     return root;

   public TreeNode bstToGst(TreeNode root) {
       findSum(root);
       preOrder(root);
       return root;
   }
    public void preOrder(TreeNode root) {
       if (root == null) {
           return;
       }
       preOrder(root.left);
       currSum += root.val;
       root.val += sum - currSum;
       preOrder(root.right);
   }

   public void findSum(TreeNode root) {
       if (root == null)
           return;
       sum += root.val;
       findSum(root.left);
       findSum(root.right);
   }
} BinarySearchTreeToGreaterSumTree(1038) {
    
}
