 class Solution {
    
    public int hammingWeight(int n) {
         int count=0;
         while(n!=0){
             int last=n&1;
             count+=last;
             n=n>>>1;
         }
         return count;
    }
}