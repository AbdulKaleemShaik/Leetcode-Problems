import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                int diff = st.peek() + asteroids[i];
                if (diff < 0) {
                    st.pop();
                } else if (diff > 0) {
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    st.pop();
                }
            }
            if (asteroids[i] != 0)
                st.add(asteroids[i]);
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}