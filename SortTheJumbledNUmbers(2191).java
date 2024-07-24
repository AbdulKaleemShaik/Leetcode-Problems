class Solution {
    // public int[] sortJumbled(int[] mapping, int[] nums) {
    // HashMap<Integer, List<Integer>> map = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // int j = nums[i];
    // int size = 0;
    // if (j == 0)
    // size = 1;
    // else
    // size = (int) Math.log10(j) + 1;
    // int num = 0;
    // for (int k = 0; k < size; k++) {
    // int l = j % 10;
    // j = j / 10;
    // num = mapping[l] * (int) Math.pow(10, k) + num;
    // }
    // if (map.containsKey(num))
    // map.get(num).add(nums[i]);
    // else {
    // map.put(num, new ArrayList<>());
    // map.get(num).add(nums[i]);
    // }
    // }
    // List<Integer> li = new ArrayList<>(map.keySet());
    // Collections.sort(li);
    // int i = 0;
    // for (Integer ji : li) {
    // List<Integer> curr = map.get(ji);
    // int size = curr.size();
    // int k = 0;
    // while (k < size) {
    // nums[i++] = curr.get(k++);
    // }
    // }
    // // System.out.println(Arrays.toString(nums));
    // return nums;
    // }

    // }
    public static int convert(int x, int[] mapping) {
        if (x == 0)
            return mapping[0]; // edge case
        int z = 0;
        int pow10 = 1;
        while (x > 0) {
            int r = x % 10;
            z += mapping[r] * pow10;
            pow10 *= 10;
            x /= 10;
        }
        return z;
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mapNum = new int[n][3]; // array to hold (mapped num, index, original num)

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            mapNum[i][0] = convert(x, mapping);
            mapNum[i][1] = i;
            mapNum[i][2] = x;
        }

        Arrays.sort(mapNum, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            nums[i] = mapNum[i][2];
        }
        return nums;
    }
}