class Solution {
    public int[] shuffle(int[] nums, int n) {
         int arr[]=new int[nums.length];
            int c=0;
        for (int i=0;i<arr.length;i=i+2)
        {
            arr[i]=nums[c];
            arr[i+1]=nums[n];
            c++;
            n++;
        }
        return arr;
    }
}