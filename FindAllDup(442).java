import java.util.*;
class Solution {
    
     static public List<Integer> findDuplicates(int[] arr) {
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
             li.add(arr[j]);
            }

        }
        return li;
    }

    static void swap(int[] ar, int f, int l) {
        int temp = ar[f];
        ar[f] = ar[l];
        ar[l] = temp;
    }
  
}
    
