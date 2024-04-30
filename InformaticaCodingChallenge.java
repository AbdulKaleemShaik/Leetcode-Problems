import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InformaticaCodingChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numPlates = scanner.nextInt();
            Map<Character, List<String>> wordsByLastLetter = new HashMap<>();

            for (int j = 0; j < numPlates; j++) {
                String word = scanner.next();
                char firstLetter = word.charAt(0);
                wordsByLastLetter.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(word);
            }
            System.out.println(wordsByLastLetter);

            if (solvePuzzle(wordsByLastLetter, 1, numPlates)) {
                System.out.println("Ordering is possible.");
            } else {
                System.out.println("The door cannot be opened.");
            }
        }
    }

    private static boolean solvePuzzle(Map<Character, List<String>> wordsByLastLetter, int ans, int count) {
        if (wordsByLastLetter.isEmpty()) {
            return true;
        }

        for (char startingLetter : wordsByLastLetter.keySet()) {
            List<String> words = wordsByLastLetter.get(startingLetter);
            if (words.isEmpty()) {
                continue;
            }
            String firstWord;
            if (words.size() > 1) {
                firstWord = words.remove(0);
                wordsByLastLetter.put(startingLetter, words);
            } else {
                firstWord = words.remove(0);
            }

            char lastLetter = firstWord.charAt(firstWord.length() - 1);

            if (ans == count) {
                return true;
            }
            if (wordsByLastLetter.containsKey(lastLetter)) {
                return solvePuzzle(wordsByLastLetter, ans + 1, count);
            }
         
        }

        return false;
    }
}
