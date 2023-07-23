class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       
        int[] num=new int[nums.length];
        for(int i=0;i<nums.length;i++){
             int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
                num[i]=count;
            }
        }
        return num;

    }
}