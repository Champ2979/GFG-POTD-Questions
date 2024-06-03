class Solution {
    static int numberOfConsecutiveOnes(int n) {
        final int MOD = (int) 1e9 + 7;

        if (n == 1) return 0;  // Since n starts from 2 as per constraints

        long[] a = new long[n + 1];
        long[] b = new long[n + 1];

        a[1] = 1;
        b[1] = 1;

        // Fill arrays using recurrence relations
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % MOD;
            b[i] = a[i - 1] % MOD;
        }

        long totalValidStrings = (a[n] + b[n]) % MOD;

        long totalStrings = powerOfTwo(n, MOD);

        long result = (totalStrings - totalValidStrings + MOD) % MOD;

        return (int) result;
    }

    // Function to compute (2^n) % MOD
    static long powerOfTwo(int n, int MOD) {
        long result = 1;
        long base = 2;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            n >>= 1;
        }
        return result;
    }
}
