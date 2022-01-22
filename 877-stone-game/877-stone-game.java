class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length-1;
        int dp[][]=new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(piles,0,n,dp)>0;
    }
    
    public int helper(int[] piles,int i,int j,int dp[][]){
        
        if(i>j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        return dp[i][j]=Math.max(piles[i]-helper(piles,i+1,j,dp),piles[j]-helper(piles,i,j-1,dp));
    }
}