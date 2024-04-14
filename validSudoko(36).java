class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet mySet = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                char currChar = board[i][j];

                if (!mySet.add(currChar + "row" + i) || !mySet.add(currChar + "col" + j)
                        || !mySet.add(currChar + "box" + i / 3 + '-' + j / 3))
                    return false;

            }
        }

        return true;
    }
}