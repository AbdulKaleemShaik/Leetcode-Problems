import java.util.*;

class Solution {

     static public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);

            } else {
                i++;
            }
        }
        List li=new ArrayList();
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
             li.add(j+1);
            }

        }
        return li;
    }

    static void swap(int[] ar, int f, int l) {
        int temp = ar[f];
        ar[f] = ar[l];
        ar[l] = temp;
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));

    }
}