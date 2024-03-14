class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        bfs(image, vis, sr, sc, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (vis[i][j]) {
                    image[i][j] = color;
                }
            }
        }
        return image;

    }

    public static void bfs(int[][] image, boolean[][] vis, int row, int col, int ele) {
        vis[row][col] = true;
        int[] rows = { -1, 1, 0, 0 };
        int[] cols = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int newroe = row + rows[i];
            int newcol = col + cols[i];
            if (newroe >= 0 && newroe < image.length && newcol >= 0 && newcol < image[0].length && !vis[newroe][newcol]
                    && image[newroe][newcol] == ele) {
                bfs(image, vis, newroe, newcol, ele);
            }
        }
    }
}