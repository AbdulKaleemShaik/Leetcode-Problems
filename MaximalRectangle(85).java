class Solution {
    public static int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i != 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
            ans = Math.max(ans, largestRectangleArea(dp[i]));
        }
        return ans;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = st.peek() + 1;
            st.push(i);
        }
        while (!st.isEmpty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;

    }
}