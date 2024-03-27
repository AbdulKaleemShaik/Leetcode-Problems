class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            }
            product *= nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
            product = 1;
        }
        return count;
        // if(k<=1){
        // return 0;
        // }
        // int cnt=0,pro=1,left=0,right=0;
        // while(right<nums.length){
        // pro*=nums[right];
        // while(pro>=k){
        // pro/=nums[left++];
        // }
        // cnt+=1+(right-left);
        // right++;
        // }
        // return cnt;
    }
}