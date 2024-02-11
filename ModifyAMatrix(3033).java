class Solution {
    public int[][] modifiedMatrix(int[][] arr) {
         for (int i = 0; i < arr.length; i++) {
            int index = 0, max = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    index = j;
                    change(arr, index, max,i);
                    
                }
            }
        }
        return arr;
        
    }
    public static  void change(int[][] arr, int index, int max,int i) {
            for (int l = 0; l < arr.length; l++) {
                if (max < arr[l][index]) {
                    max = arr[l][index];
                }
            }
            arr[i][index] = max;
        }
}