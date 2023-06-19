import java.util.*;
class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int max=-1;
        for(int i=0;i<nums.length;i++){
            if(Arrays.binarySearch(nums,-nums[i] )>=0 ){
                max=Math.max(max,nums[i]);
            }
            
        }
        return max;
        
    }
}