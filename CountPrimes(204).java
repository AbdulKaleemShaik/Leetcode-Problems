class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        return prime(n);

    }

    private int prime(int n) {
        int[] box = new int[n];
        for (int i = 2; i < n; i++) {
            box[i] = 1;
        }
        int ans = 0;
        for (int i = 3; i < Math.sqrt(n); i++) {
            if (box[i] == 1) {

                for (int j = i * 2; j <= n; j += i) {
                    box[j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (box[i] == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            isPrime[i] = true;
        }

        isPrime[2] = true;

        for (int i = 3; i * i < n; i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;

    }
}