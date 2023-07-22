class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count=new int[101];
        int ans=0;
        for(int n:nums){
            count[n]++;
        }
        for(int n:count){
            ans += (n*(n-1))/2;
        }
        return ans;
    }
}