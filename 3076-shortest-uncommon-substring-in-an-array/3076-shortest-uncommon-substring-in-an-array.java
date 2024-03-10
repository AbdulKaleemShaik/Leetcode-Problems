class Solution {
    public String[] shortestSubstrings(String[] arr) {
        String[] ans = new String[arr.length];
        Arrays.fill(ans, "");
        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i];
            int minlen = Integer.MAX_VALUE;
            String str = "";
            for (int j = 0; j < curr.length(); j++) {
                for (int k = j + 1; k <= curr.length(); k++) {
                    String substring = curr.substring(j, k);
                    boolean find = false;

                    for (int l = 0; l < arr.length; l++) {
                        if (l != i && arr[l].contains(substring)) {
                            find = true;
                            break;
                        }
                    }
                    if (!find && (substring.length() < minlen
                            || (substring.length() == minlen && substring.compareTo(str) < 0))) {
                        minlen = substring.length();
                        str = substring;
                    }

                }
            }
            ans[i] = str;
        }
        return ans;
    }
}