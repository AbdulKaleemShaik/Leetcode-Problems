class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Character, Integer> k : map.entrySet()) {
            pq.add(new pair(k.getKey(), k.getValue()));
        }
        pair p = null;
        while (!pq.isEmpty()) {
            p = pq.poll();
            for (int i = 0; i < p.value; i++) {
                sb.append(p.key);
            }
        }
        return sb.toString();
    }
}

class pair {
    char key;
    int value;

    pair(char i, int j) {
        this.key = i;
        this.value = j;
    }
}