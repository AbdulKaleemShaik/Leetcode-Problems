class Solution {
    public double averageWaitingTime(int[][] customers) {
        if (customers.length == 0)
            return 0;
        int currTime = customers[0][0];
        double averageTime = 0;
        for (int i = 0; i < customers.length; i++) {
            if (currTime <= customers[i][0])
                currTime = customers[i][0];
            currTime += customers[i][1];
            averageTime += currTime - customers[i][0];
        }
        return averageTime / customers.length;
    }
}