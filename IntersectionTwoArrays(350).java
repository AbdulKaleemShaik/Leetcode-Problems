class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0, j = 0;
        List<Integer> li = new ArrayList<>();
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            } else if (num1[i] > num2[j]) {
                j++;
            } else {
                li.add(num1[i]);
                i++;
                j++;

            }
        }
        int[] op = new int[li.size()];
        int k = 0;
        while (k < li.size()) {
            op[k] = li.get(k);
            k++;
        }
        return op;
    }
}