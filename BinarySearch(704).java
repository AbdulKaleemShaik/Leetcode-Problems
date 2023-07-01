class Solution {
    public int search(int[] nums, int target) {
        int ans=binary(nums,target,0,nums.length-1);
        return ans;
    }
    static int binary(int[] array,int target,int start,int end){
        int mid=start+(end-start)/2;
        if(start>end){
            return -1;
        }
        if(array[mid]==target){
            return mid;
        }
        else if(target<array[mid]){
            return binary(array,target,start,mid-1);
        }
        else{
            return binary(array,target,mid+1,end);
        }
    }

}