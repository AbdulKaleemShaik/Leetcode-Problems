class Solution { 
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int ans = 1;
        int idx = 0;

        while(idx < arr.length && count < k) {
            if(arr[idx]==ans) {
                ans++;
                idx++;
            }
            else {
                ans++;
                count++;
            }
        }

        while(count < k) {
            ans++;
            count++;
        }
        
        return ans-1;
    }
}