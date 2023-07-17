class Solution {
    public boolean isSubsequence(String s, String t) {
        int x=0,count=0;
        if(s.length()==0){
            return true;
        }
        else{
        for(int i=0;i<t.length();i++){
            if(count<s.length()){
             if(s.charAt(x)==t.charAt(i)){
                    x++;
                     count++;
   }}
     }
     if(s.length()==count){
         return true;
     }
     return false;

    }
    }
}
