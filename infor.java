import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class infor {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] dis = new int[t][t];
        for (int i = 0; i < t; i++) {
            String curr = sc.next();
            map.put(curr, i);
            int neighbours = sc.nextInt();
            for (int j = 0; j < neighbours; j++) {
                int k = sc.nextInt();
                int l = sc.nextInt();
                dis[i][k - 1] = l;
            }
        }
        int src = map.get(sc.next());
        int desc = map.get(sc.next());

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (i != j && dis[i][j] == 0) {
                    dis[i][j] = (int) (1e9);
                }
            }
        }

        // Floydd-Warshall Algorithm
        for (int k = 0; k < t; k++) {
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (dis[i][k] + dis[k][j] < dis[i][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }

                }
            }
        }
        System.out.println(dis[src][desc]);
    }
}
