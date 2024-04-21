import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class solution {
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();

    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, Integer> degrees = new HashMap<>();

        for (int[] p : pairs) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new Stack<>());
            }
            map.get(p[0]).push(p[1]);

            degrees.put(p[0], degrees.getOrDefault(p[0], 0) - 1);
            degrees.put(p[1], degrees.getOrDefault(p[1], 0) + 1);
        }

        int start = pairs[0][0];
        for (int[] p : pairs) {
            if (degrees.get(p[0]) == -1) {
                start = p[0];
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        calculate(start, path);
        Collections.reverse(path);

        int[][] res = new int[pairs.length][2];

        for (int i = 1; i < path.size(); i++) {
            res[i - 1][0] = path.get(i - 1);
            res[i - 1][1] = path.get(i);
        }

        return res;
    }

    public void calculate(int v, List<Integer> path) {
        while (map.containsKey(v) && map.get(v).size() > 0) {
            calculate(map.get(v).pop(), path);
        }
        path.add(v);
    }
}