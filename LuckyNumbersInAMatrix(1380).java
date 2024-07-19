
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        int maxi = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < maxi)
                    maxi = matrix[i][j];
            }
            st.add(maxi);
            maxi = Integer.MAX_VALUE;
        }
        maxi = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (maxi < matrix[j][i])
                    maxi = matrix[j][i];
            }
            if (st.contains(maxi))
                ans.add(maxi);
            maxi = Integer.MIN_VALUE;
        }
        return ans;
    }
}

// List<Integer> lsRes = new ArrayList<>();

// for(int i = 0; i < matrix.length; i++)
// {
// int col = findMin(matrix, i);

// int maxCol = matrix[i][col];
// if(maxInCol(matrix, maxCol, col))
// lsRes.add(maxCol);

// return lsRes;
// }
// private int findMin(int[][] matrix, int row){
// int val= matrix[row][0], col=0;
// for(int i=1;i<matrix[row].length;i++){
// if(matrix[row][i]<val){
// val=matrix[row][i];
// col=i;
// }
// }
// return col;
// }
// private boolean maxInCol(int[][] matrix, int val, int col){
// for(int i=0;i<matrix.length;i++){
// if(matrix[i][col]>val)
// return false;
// }
// return true;
// }