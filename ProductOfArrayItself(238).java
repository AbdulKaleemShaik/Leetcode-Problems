class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] nums = new int[arr.length];
        int rightmost = 1;
        int count = 0;
        for (int i : arr) {
            if (i == 0) {
                count++;
                continue;
            } else {
                rightmost = rightmost * i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (count == 1) {
                if (arr[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = rightmost;
                }

            } else if (count > 0) {
                nums[i] = 0;
            } else {
                nums[i] = rightmost / arr[i];
            }

        }
        return nums;
    }
}