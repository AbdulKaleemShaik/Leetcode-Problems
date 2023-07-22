class Solution {
    public String longestCommonPrefix(String[] arr) {
        if (arr.length == 0)
            return "";
        String op = arr[0];
        for (int i = 1; i < arr.length; i++)
            while (arr[i].indexOf(op) != 0)
                op = op.substring(0, op.length() - 1);
        return op;
    }
}