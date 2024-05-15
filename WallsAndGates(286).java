import java.util.Arrays;
import java.util.PriorityQueue;

public class WallsAndGate {
    public void wallsAndGates(int[][] rooms) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.i - b.i);
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    pq.add(new pair(0, i, j));
                }
            }
        }
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int time = p.i;
            int i = p.j;
            int j = p.k;
            int[] rows = { 1, -1, 0, 0 };
            int cols[] = { 0, 0, 1, -1 };
            for (int idx = 0; idx < 4; idx++) {
                if (i + rows[idx] >= 0 && i + rows[idx] < m && j + cols[idx] >= 0 && j + cols[idx] < n
                        && (rooms[i + rows[idx]][j + cols[idx]] == Integer.MAX_VALUE)) {
                    rooms[i + rows[idx]][j + cols[idx]] = time + 1;
                    pq.add(new pair(time + 1, i + rows[idx], j + cols[idx]));
                }
            }
        }
        for (int[] ij : rooms) {
            System.out.println(Arrays.toString(ij));
        }
    }

    public static void main(String[] args) {
        WallsAndGate wr = new WallsAndGate();
        wr.wallsAndGates(new int[][] { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } });
    }

}

class pair {
    int i, j, k;

    pair(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
