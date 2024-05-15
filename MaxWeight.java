import java.util.Arrays;
import java.util.List;

public class MaxWeight {
    public static int maxWeightCell(int N, List<Integer> Edge) {

        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            if (Edge.get(i) != -1) {
                temp[Edge.get(i)] += i;
            }
        }
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (temp[i] >= max) {
                ans = i;
                max = temp[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(0, 2, 2, 3);
        System.out.println(maxWeightCell(4, li));
    }

}
