import java.util.Scanner;

class MatrixTrace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(findMatrixTrace(matrix, n));
        }
        sc.close();
    }

    public static int findMatrixTrace(int[][] matrix, int n) {
        int maxMatrictrace = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int r = 0; r <= n - i; r++) {
                for (int c = 0; c <= n - i; c++) {
                    int currtrace = 0;
                    for (int j = 0; j < i; j++) {
                        currtrace += matrix[j + r][j + c];
                    }
                    maxMatrictrace = Math.max(maxMatrictrace, currtrace);
                }
            }
        }
        return maxMatrictrace;
    }
}
