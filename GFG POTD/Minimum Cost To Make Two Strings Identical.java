class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
        int n = y.length();
        
       
        int[][] dp = new int[m + 1][n + 1];
        
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i * costX;
        }
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * costY;
        }
        
       
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + costX, dp[i][j - 1] + costY);
                }
            }
        }
        
        
        return dp[m][n];
    }
}
