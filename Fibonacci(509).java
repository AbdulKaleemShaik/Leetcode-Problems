class Solution {
    public int fib(int n) {
        int ans=fibonacci(n);
        return ans;
    }
    static int fibonacci(int n){
        
        if(n==0 || n==1){
            return n;
        }
       
        else{
        return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
