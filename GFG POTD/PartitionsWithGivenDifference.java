class Solution {
    public int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int mod = 1000000007;
        int[][] dp = new int[n + 1][totalSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % mod;
                }
            }
        }

        int count = 0;
        for (int j = (totalSum + 1) / 2; j <= totalSum; j++) {
            if (Math.abs(j - (totalSum - j)) == d) {
                count = (count + dp[n][j]) % mod;
            }
        }

        return count;
    }
}
