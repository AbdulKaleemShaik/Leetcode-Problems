import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        // int ans = 0;
        // Map<Character, Integer> map = new HashMap<>();
        // for (int c = 0; c < word.length(); c++) {
        // map.put(word.charAt(c), map.getOrDefault(word.charAt(c), 0) + 1);
        // }
        // PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.i - a.i);
        // for (Map.Entry<Character, Integer> m : map.entrySet()) {
        // pq.add(new pair(m.getKey(), m.getValue()));
        // }
        // int idx = 0;
        // while (!pq.isEmpty()) {
        // pair p = pq.poll();
        // ans += p.i * (1 + idx++ / 8);
        // }
        // return ans;
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        Arrays.sort(arr);
        int i = 25;
        int count = 0;
        int start = 1;
        int ans = 0;
        while (i >= 0 && arr[i] != 0) {
            ans += (start * arr[i]);
            count++;
            if (count == 8) {
                start++;
                count = 0;
            }
            i--;
        }
        return ans;
    }
}

class pair {
    Character ch;
    int i;

    pair(char c, int i) {
        this.ch = c;
        this.i = i;
    }
}