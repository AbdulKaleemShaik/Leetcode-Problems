class Solution {
    public int[] sortArray(int[] nums) {
        // merge(nums, 0, nums.length - 1);
        // // System.out.println(Arrays.toString(nums));
        // return nums;
        // }

        // public void merge(int[] arr, int low, int high) {
        // if (low == high)
        // return;
        // int mid = low + (high - low) / 2;
        // merge(arr, low, mid);
        // merge(arr, mid + 1, high);
        // merging(arr, low, mid, high);
        // }

        // private void merging(int[] arr, int low, int mid, int high) {
        // int[] temp = new int[high - low + 1];
        // int li = low, ri = mid + 1;
        // for (int i = 0; i < temp.length; i++) {
        // if (ri > high)
        // temp[i] = arr[li++];
        // else if (li > mid)
        // temp[i] = arr[ri++];
        // else if (arr[li] < arr[ri])
        // temp[i] = arr[li++];
        // else
        // temp[i] = arr[ri++];
        // }
        // for (int i = 0; i < temp.length; i++)
        // arr[i + low] = temp[i];
        int maxi = nums[0];
        int mini = nums[0];

        for (int num : nums) {
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }

        int n = maxi - mini;
        int[] temp = new int[n + 1];

        for (int num : nums) {
            temp[num - mini]++;
        }

        int idx = 0;

        for (int i = 0; i <= n; i++) {
            while (temp[i] > 0) {
                nums[idx] = mini;
                idx++;
                temp[i]--;
            }

            mini++;
        }

        return nums;
    }

}