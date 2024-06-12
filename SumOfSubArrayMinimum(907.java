import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int[] leftMin = new int[arr.length];
        int[] rightMin = new int[arr.length];
        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, arr.length);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty())
                leftMin[i] = st.peek();
            st.add(i);
        }

        st.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (!st.isEmpty())
                rightMin[i] = st.peek();
            st.add(i);
        }
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            ans += (long) (i - leftMin[i]) * (rightMin[i] - i) % mod * arr[i] % mod;
            ans %= mod;
        }
        return (int) ans;
    }
}