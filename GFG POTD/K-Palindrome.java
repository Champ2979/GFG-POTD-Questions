class Solution {
    public int kPalindrome(String str, int n, int k) {
        int[][] dp = new int[n][n];
        
       
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0; // A single character is already a palindrome
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] <= k ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kPalindrome("abcdecba", 8, 1)); 
        System.out.println(solution.kPalindrome("abcdefcba", 9, 1)); 
    }
}
