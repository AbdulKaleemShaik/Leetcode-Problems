class Solution {
    public int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }

    void swap(int[] arr, int f, int l) {
        int temp = arr[f];
        arr[f] = arr[l];
        arr[l] = temp;
    }
}
