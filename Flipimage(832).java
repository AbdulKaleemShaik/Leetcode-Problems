class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

			int start = 0;
			int end = arr[i].length - 1;

			while (start < end) {

				int temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;

				start++;
				end--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = arr[i][j] ^ 1;
			}

		}
		return arr;
    }
}