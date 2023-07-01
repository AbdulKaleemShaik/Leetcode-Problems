class Solution {
    public void reverseString(char[] arr) {
        int i = 0, j = arr.length - 1;
        for (int k = 0; k < arr.length / 2; k++) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void swap(char[] array, int l, int m) {
        char temp = array[l];
        array[l] = array[m];
        array[m] = temp;
    }
}