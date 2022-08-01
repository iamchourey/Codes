class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[][]=new int[m+1][n+1];
        //dp[m][n]=1;
        
        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==m || j==n) dp[i][j]=1;
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[1][1];
    }
}