class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
       
        int[] dp = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        
        dp[0] = 0;
        
        
        for (int i = 1; i <= n; i++) {
            if (cost[i - 1] != -1) {
                for (int j = i; j <= w; j++) {
                    if (dp[j - i] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - i] + cost[i - 1]);
                    }
                }
            }
        }
        
        
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}