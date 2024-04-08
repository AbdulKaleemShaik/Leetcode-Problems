class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] c = new int[2];
        for (int student : students) c[student]++;
        
        int rem = sandwiches.length;
        for (int sandwich : sandwiches) {
            if (c[sandwich] == 0) break;
            if (rem-- == 0) break;
            c[sandwich]--;
        }
        
        return rem;
    }
}
