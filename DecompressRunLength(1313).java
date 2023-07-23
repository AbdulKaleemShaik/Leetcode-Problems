import java.util.ArrayList;
import java.util.Arrays;

class Solution {
   public static  int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int size=0;
        for (int i = 0; i < nums.length; i+=2) {
            size=size+nums[i];
        }
        int[] ar=new int[size];

        int start=0;
        for (int i = 0; i < nums.length; i+=2) {
            Arrays.fill(ar,start,start+nums[i],nums[i+1]);
            start+=nums[i];
            
        }
        return ar;
    }
}