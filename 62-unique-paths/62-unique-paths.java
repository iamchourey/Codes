class Solution {
    public int uniquePaths(int m, int n) {
        int memo[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(m,n,memo);
    }
    
    public int helper(int m,int n,int[][] dp){
        if(m==1 || n==1) return dp[m][n]=1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=helper(m-1,n,dp)+helper(m,n-1,dp);
    }
}