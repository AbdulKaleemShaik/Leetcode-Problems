import java.util.Arrays;

class Solution {
    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.sort(nums);
        // int k=0,j=1,h=0;
        // for(int i=0;i<(nums.length)/2;i++){
        // arr[h]=nums[j];
        // h++;
        // arr[h]=nums[k];
        // h++;
        // j+=2;
        // k+=2;
        // }T
        for (int i = 0; i < nums.length - 1; i += 2) {
            int a = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = a;
        }
        return nums;

    }
}