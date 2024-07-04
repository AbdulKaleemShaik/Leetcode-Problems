import java.util.*;

public class GFG {

    static void display(int countLeftGreater[], int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(countLeftGreater[i] + " ");
        }
    }

    public static void countGreater(int arr[], int N) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        int[] countLeftGreater = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : countMap.tailMap(arr[i], false).entrySet()) {
                count += entry.getValue();
            }
            countLeftGreater[i] = count;
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(countMap);
        display(countLeftGreater, N);
    }

    public static void main(String[] args) {
        int arr[] = { 12, 1, 2, 3, 0, 11, 4 };
        int N = arr.length;

        countGreater(arr, N);
    }
}
