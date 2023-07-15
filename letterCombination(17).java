
class Solution {
    public List<String> letterCombinations(String digits) 
    {   ArrayList<String> list=new ArrayList<>();
        if(digits.isEmpty()) return list;

        return  phonePad("",digits);
    }
    public List<String> phonePad(String p, String up)
    {
         if(up.isEmpty())
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        // thsi will convert like,'2' into 2
         int digit=up.charAt(0) - '0' ;
         ArrayList<String> list=new ArrayList<>();
         int i=(digit - 2) * 3;
         if( digit > 7) i+=1;
         int len=i + 3;
         if( digit == 7 || digit == 9) len+=1;
         for(;i< len; i++)
        {
          char ch= (char) ('a' + i);
          list.addAll(phonePad(p + ch, up.substring(1)));
        }
        return list;
   }
}
