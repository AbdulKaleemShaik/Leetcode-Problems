import java.util.Stack;

class Solution {
    public int[] resultArray(int[] nums) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        if (nums.length >= 2) {
            st1.push(nums[0]);
            st2.push(nums[1]);
        }
        // System.out.println(st1);
        for (int i = 2; i < nums.length; i++) {
            if (st1.peek() > st2.peek()) {
                st1.push(nums[i]);
            } else {
                st2.push(nums[i]);
            }
        }
        int[] arr = new int[nums.length];
        for (int i = st1.size() - 1; i >= 0; i--) {
            arr[i] = st1.pop();
        }
        int last = arr.length - 1;
        for (int i = st2.size() - 1; i >= 0; i--) {
            arr[last--] = st2.pop();
        }
        // System.out.println(Arrays.toString(arr));
        return arr;

    }
}