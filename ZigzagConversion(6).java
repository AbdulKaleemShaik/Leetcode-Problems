import java.util.ArrayList;
import java.util.List;

 class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int currRow = 0, nextColorRow = 1;
        List<Character>[] li = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            li[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            li[currRow].add(c);
            if (currRow == 0) {
                nextColorRow = 1;
            } else if (currRow == numRows - 1) {
                nextColorRow = -1;
            }
            currRow += nextColorRow;
        }

        StringBuilder ans = new StringBuilder();
        for (List<Character> row : li) {
            for (char c : row) {
                ans.append(c);
            }
        }

        return ans.toString();
    }

} 
