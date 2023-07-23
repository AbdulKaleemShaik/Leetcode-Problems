import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char sep) {
         List<String> result=new ArrayList<>();
      for (String word : words) {
        String str="\\"+Character.toString(sep);
        String[] newWordArr=word.split(str);
        for (String s : newWordArr) {
            boolean isEmpty = s == null || s.trim().length()==0;
            if(!isEmpty){
                result.add(s);
            }
        }
      }
        return result; 
    }
}