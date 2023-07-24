class Solution {
   public static  String restoreString(String s, int[] indices) {
        StringBuilder sb=new StringBuilder("");
        char[] s1=new char[indices.length];
        for(int i=0;i<s.length();i++){
            s1[indices[i]]=s.charAt(i);
        }
        sb.append(s1);
        return sb.toString();
    }
}