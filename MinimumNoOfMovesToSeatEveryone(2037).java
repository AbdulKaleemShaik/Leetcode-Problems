class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int size = Integer.MIN_VALUE;
        for (int i : seats) {
            size = Math.max(i, size);
        }
        for (int i : students) {
            size = Math.max(i, size);
        }
        int res = 0;
        int[] arr1 = new int[size + 1];
        int[] arr2 = new int[size + 1];
        for (int i : seats)
            arr1[i]++;
        for (int i : students)
            arr2[i]++;

        int rem = students.length;
        int i = 0, j = 0;
        while (rem != 0) {
            if (arr1[i] == 0)
                i++;
            if (arr2[j] == 0)
                j++;
            if (arr1[i] != 0 && arr2[j] != 0) {
                res += Math.abs(i - j);
                arr1[i]--;
                arr2[j]--;
                rem--;
            }
        }
        return res;
        int res = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}