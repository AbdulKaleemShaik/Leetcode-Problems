class Solution {
    public int pivotIndex(int[] arr) {
        int leftmost = 0;
        int rightmost = 0;
        for (int i : arr) {
            rightmost += i;
        }
        for (int i = 0; i < arr.length; i++) {
            leftmost = leftmost + arr[i];
            rightmost = rightmost - arr[i];
            if (leftmost - arr[i] == rightmost) {
                return i;
            }

        }
        return -1;
    }
}