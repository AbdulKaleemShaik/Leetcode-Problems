class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i] + " ");
        }
        return sb.append(arr[arr.length - 1]).toString();
    }
}