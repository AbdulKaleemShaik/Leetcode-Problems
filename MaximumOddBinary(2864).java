import java.util.HashMap;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int[] arr = new int[s.length()];
        int one = map.get('1');
        if (one != 0) {
            arr[arr.length - 1] = 1;
        }
        for (int i = 0; i < one - 1; i++) {
            arr[i] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
        // int countOnes = 0;
        // StringBuilder resultBuilder = new StringBuilder();

        // for (char ch : binaryString.toCharArray()) {
        // if (ch == '1') {
        // countOnes++;
        // }
        // }

        // for (int i = 0; i < binaryString.length() - 1; i++) {
        // if (countOnes > 1) {
        // countOnes--;
        // resultBuilder.append('1');
        // } else {
        // resultBuilder.append('0');
        // }
        // }

        // resultBuilder.append('1');
        // return resultBuilder.toString();

    }
}