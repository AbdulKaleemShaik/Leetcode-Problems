import java.util.HashMap;
import java.util.Map;
//100284. Valid Word

public class validWord {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("digit", 0);
        map.put("vowels", 0);
        map.put("consonants", 0);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                map.put("vowels", map.getOrDefault("vowels", 0) + 1);
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                map.put("consonants", map.getOrDefault("consonants", 0) + 1);
            } else if (ch >= '0' && ch <= '9') {
                map.put("digit", map.getOrDefault("digit", 0) + 1);
            } else {
                return false;
            }
        }
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            if (i.getValue() < 1 && i.getKey()!="digit") {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        validWord vr = new validWord();
        System.out.println(vr.isValid("AhI"));
    }
}
