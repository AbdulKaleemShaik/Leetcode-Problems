import javax.swing.tree.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }
    /**
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public TreeNode BST(int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=BST(nums,l,mid-1);
        root.right=BST(nums,mid+1,r);
        return root;
    }
}