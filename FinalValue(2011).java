class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String operation : operations) {
            count += getValue(operation);
        }
        return count;
    }

    private int getValue(String operation) {
        char aChar = operation.charAt(1);
        return aChar == '+' ? 1 : -1;
    }
}