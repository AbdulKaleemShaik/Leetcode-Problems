class Solution {
    public static int countBattleships(char[][] board) {
        int count = 0;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!vis[i][j] && board[i][j] == 'X') {
                    count++;
                    dfs(board, vis, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] board, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        int rowmov[] = { -1, 1, 0, 0 };
        int colmov[] = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int roww = row + rowmov[i];
            int coll = col + colmov[i];
            if (roww >= 0 && roww < board.length && coll >= 0 && coll < board[0].length && board[roww][coll] == 'X'
                    && !vis[roww][coll]) {

                dfs(board, vis, roww, coll);
            }
        }
    }
}