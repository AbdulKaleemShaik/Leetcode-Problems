 class Solution {
    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10 && i != 0) {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
            if (digits[i] == 10) {
                int[] copy = new int[digits.length + 1];
                copy[i] = 1;
                return copy;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ans={1,2,3};
        int[] arr=plusOne(ans);
        System.out.println(arr.toString());
    }
}