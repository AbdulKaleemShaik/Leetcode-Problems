import java.util.Arrays;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] arr = new int[deck.length];
        arr[0] = deck[0];
        int j = 1;
        int idx = 1;
        int count = 1;
        while (idx < deck.length) {
            if (arr[j] == 0 && count == 2) {
                arr[j] = deck[idx];
                count = 1;
                idx++;
            }
            if (arr[j] == 0) {
                count++;
            }
            j = (j + 1) % deck.length;
        }
        return arr;
    }
}