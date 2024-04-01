class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles;
        int bottles = 0;
        while (empty >= numExchange) {
            bottles++;
            empty = empty - numExchange;
            numExchange++;
            if (empty <= numExchange) {
                ans += bottles;
                empty += bottles;
                bottles = 0;
            }
        }
        return ans;
    }
}