class Solution {
    public int maximumSwap(int num) {
        int size = (int) Math.log10(num) + 1;
        int[] arr = new int[size];
        int temp = num;
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num = num / 10;
        }
        int maxNum = 0, maxIndex = -1, swap_i = -1, swap_j = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                maxIndex = i;
            }
            if (arr[i] < maxNum) {
                swap_i = i;
                swap_j = maxIndex;
            }
        }
        if (swap_i == -1 || swap_j == -1)
            return temp;
        int curr = arr[swap_i];
        arr[swap_i] = arr[swap_j];
        arr[swap_j] = curr;
        int ans=0;
        for(int i=0;i<size;i++){
            ans=ans*10+arr[i];
        }
        return ans;
    }
}