class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int[] ar : accounts){
            int sum=0;
            for(int arr:ar){
                sum=sum+arr;
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}