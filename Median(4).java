import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        double ans;
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];

        }
        for (int j = nums1.length, k = 0; k < nums2.length; j++, k++) {
            arr[j] = nums2[k];
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int n = arr.length;
       // System.out.println(n);
        int mid = arr.length / 2;
       // System.out.println(mid);
        if (n % 2 == 0) {
            ans =(double) (arr[mid] + arr[mid - 1]) / 2;
            return ans;
        } else {
            ans = arr[n / 2];
            return ans;
        }

    }
    // public static void main(String[] args) {
    //     int[] num1={1,2};
    //     int[] num2={3,4};
    //     Solution sr=new Solution();
    //    System.out.println( sr.findMedianSortedArrays(num1, num2));
    // }
}
