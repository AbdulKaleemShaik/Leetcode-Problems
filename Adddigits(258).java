class Solution {
    public int addDigits(int num) {
        return add(num,0);
    }
    static int add(int n,int sum){
         while(n>0){
            int rem=n%10;
             sum=sum+rem;
             n=n/10;
         }
         if(sum/10!=0){
          return   add(sum,0);
         }
         return sum;
    }
}