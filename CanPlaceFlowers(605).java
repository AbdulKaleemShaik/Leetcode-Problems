class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // if (n == 0)
        // return true;
        // for (int i = 0; i < flowerbed.length; i++) {
        // if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
        // && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        // flowerbed[i] = 1;
        // n--;
        // if (n == 0)
        // return true;
        // }
        // }

        // return false;
        int i = 0;
        while (i < flowerbed.length && n >= 0) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if (i + 1 > flowerbed.length - 1) {
                    n--;
                    i += 1;
                } else if (flowerbed[i + 1] == 0) {
                    n--;
                    i += 2;
                } else {
                    i += 3;
                }
            }
        }
        return n <= 0 ? true : false;
    }
}-\
