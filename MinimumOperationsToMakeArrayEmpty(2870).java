import java.util.HashMap;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count = 0;
        for (HashMap.Entry<Integer, Integer> m : map.entrySet()) {
            int k = m.getValue();
            if (k == 1) {
                return -1;
            } 
            count=count+k/3;
            if(k%3!=0){
                count++;
            }

        }
        return count;
    }
}