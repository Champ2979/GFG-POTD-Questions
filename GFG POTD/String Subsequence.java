class Solution {
    static int dp[][];
    static int mod = 1000000007;
    public static int countWays(String s1, String s2) {

        int n = s1.length(), m=s2.length();
        dp = new int[n+1][m+1];
      for(int i=1; i<=m; i++){
          dp[0][i]=0;
      }
      for(int i=0; i<=n;i++)
      dp[i][0]=1;

      for(int i=1;i<=n; i++){
          for(int j=1; j<=m; j++){
              if(s1.charAt(i-1)==s2.charAt(j-1))
              dp[i][j] = (dp[i-1][j-1]%mod + dp[i-1][j]%mod)%mod;

              else
                dp[i][j] =  dp[i-1][j]; 
          }
      }

      return  dp[n][m] ;
    }

}