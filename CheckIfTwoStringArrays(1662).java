
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String s : word1) {
            sb.append(s);
        }
        StringBuilder SB = new StringBuilder();
        for (String s : word2) {
            SB.append(s);
        }
        if (sb.toString().equals(SB.toString())) {
            return true;
        }
        return false;
    }
}