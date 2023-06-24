class Solution {
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        
        while(i < n){
            
            int idx = nums[i] - 1;
            
            if(nums[i] != nums[idx]){
                swap(i, idx, nums);
            }
            else{
                ++i;   
            }
        }
        
        for(i = 0; i < n; ++i){
            if(nums[i] != i + 1){
                return new int[]{nums[i], i + 1};
            }
        }
        
        return null;
    }
}