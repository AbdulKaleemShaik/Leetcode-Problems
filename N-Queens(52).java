class Solution {
    public int totalNQueens(int n) {
        boolean[][] br = new boolean[n][n];
        return queens(br,0);
    }
    static int queens(boolean[][] board, int r) {
        if (r == board.length) {
            dispaly(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            {
                if (isSafe(board, r, col)) {
                    board[r][col] = true;
                    count += queens(board, r + 1);
                    board[r][col] = false;
                }
            }

        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int col) {
        // to check whether the Queen is present in that column or not
        for (int i = 0; i < r; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // diagonal left
        int maxleft = Math.min(r, col);
        for (int i = 1; i <= maxleft; i++) {
            if (board[r - i][col - i]) {
                return false;
            }

        }

        // diagonal right
        int maxRight = Math.min(r, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r - i][col + i]) {
                return false;
            }

        }
        return true;
    }

    private static void dispaly(boolean[][] board) {
        for (boolean[] bs : board) {
            for (boolean bs2 : bs) {
                if (bs2) {
                    System.out.print("Q ");
                } else {
                    System.out.print("x ");
                }

            }
            System.out.println();
        }
    }

}