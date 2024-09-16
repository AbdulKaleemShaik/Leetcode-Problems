class Solution {
    public int findMinDifference(List<String> timePoints) {
         int ans = Integer.MAX_VALUE;
        int[] hourToMinutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String curr = timePoints.get(i);
            int hours = Integer.parseInt(curr.substring(0, 2));
            int minutes = Integer.parseInt(curr.substring(3));
            hourToMinutes[i] = 60 * hours + minutes;
        }
        Arrays.sort(hourToMinutes);
        for (int i = 0; i < hourToMinutes.length-1; i++) {
            ans = Math.min(ans, hourToMinutes[i+1] - hourToMinutes[i]);
        }
        return Math.min(ans, 24 * 60 - hourToMinutes[hourToMinutes.length - 1] + hourToMinutes[0]);
    }
}