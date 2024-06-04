class Solution {
    public int longestPalindrome(String s) {
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        for (Integer i : map.values()) {
            if (i % 2 != 0)
                cnt++;
        }
        if (cnt > 0)
            return s.length() - cnt + 1;
        return s.length();
    }
}