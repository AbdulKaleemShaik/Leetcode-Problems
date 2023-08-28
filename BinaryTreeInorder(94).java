import java.util.ArrayList;
import java.util.List;

class Solution {
     public List<Integer> ans=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}