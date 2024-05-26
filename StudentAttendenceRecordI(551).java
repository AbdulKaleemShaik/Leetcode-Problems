class Solution {
    public boolean checkRecord(String s) {
        int absent = 0, late = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                if (absent >= 2)
                    return false;
            }
            if (c == 'L') {
                late++;
                if (late >= 3)
                    return false;
            } else {
                late = 0;
            }
        }
        return true;
    }
}