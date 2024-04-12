class Solution {
    public int trap(int[] h) {
        int j = h.length - 1;
        int[] left = new int[h.length];
        int[] right = new int[h.length];
        int left1 = Integer.MIN_VALUE;
        int right1 = Integer.MIN_VALUE;
        for (int i = 0; i < h.length; i++) {
            left1 = Math.max(left1, h[i]);
            left[i] = Math.max(left1, h[i]);
            right1 = Math.max(right1, h[j]);
            right[j] = Math.max(right1, h[j]);
            j--;
        }
        int count = 0;
        for (int i = 0; i < h.length; i++) {
            count += Math.min(left[i], right[i]) - h[i];
        }
        return count;
    }
}