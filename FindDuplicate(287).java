class Solution {
    public int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i]!=arr[arr[i]-1]){
                swap(arr,i,arr[i]-1);
            }
            else{
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j+1){
                return arr[j];
            }
        }
        return -1;
        
    }
    static void swap(int[] arr,int f,int l){
        int temp=arr[f];
        arr[f]=arr[l];
        arr[l]=temp;
    }
}