class Solution {
    public long getCount(int n) {
        if (n == 1) return 10;

        // Possible moves for each digit
        int[][] moves = {
            {0, 8},        // 0
            {1, 2, 4},     // 1
            {2, 1, 3, 5},  // 2
            {3, 2, 6},     // 3
            {4, 1, 5, 7},  // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9},  // 6
            {7, 4, 8},     // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8}      // 9
        };

        // dp[i][j] -> number of sequences of length i ending at digit j
        long[][] dp = new long[n + 1][10];
        
        // Initial state: for sequences of length 1
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // Fill dp table
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                dp[len][digit] = 0;
                for (int move : moves[digit]) {
                    dp[len][digit] += dp[len - 1][move];
                }
            }
        }

        // Sum up all sequences of length n for all digits
        long totalCount = 0;
        for (int i = 0; i <= 9; i++) {
            totalCount += dp[n][i];
        }

        return totalCount;
    }
}
