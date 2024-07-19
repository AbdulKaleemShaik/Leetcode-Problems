import java.util.ArrayList;
import java.util.List;

public class FindCommonElementsInThreeSortedArrays {
    public List<Integer> findAll(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;

            } else if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr3[k])
                j++;
            else
                k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindCommonElementsInThreeSortedArrays fr = new FindCommonElementsInThreeSortedArrays();
        System.out.println(
                fr.findAll(new int[] { 1, 5, 5, 10, 20, 30 }, new int[] { 5, 5, 13, 15, 20 }, new int[] { 5, 5, 20 }));
    }
}
