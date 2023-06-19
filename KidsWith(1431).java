import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0 ;
        for(int candy: candies) {
            if(candy > maxCandy) {
               maxCandy = candy;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int currentCandy : candies) {
            if(currentCandy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}