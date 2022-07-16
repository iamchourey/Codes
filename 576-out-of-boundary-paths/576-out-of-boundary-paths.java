class Solution {
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        long dp[][][]=new long[m+1][n+1][maxMove+1];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return (int)helper(m,n,maxMove,startRow,startColumn,dp)%mod;
    }
    
    public long helper(int m,int n,int maxMoves,int startRow,int startColumn,long[][][] dp){
        
        if(startRow<0 || startRow>=m || startColumn<0 || startColumn>=n) return 1;
        if(maxMoves==0) return 0;
        
        if(dp[startRow][startColumn][maxMoves]!=-1) return dp[startRow][startColumn][maxMoves];
        
        return dp[startRow][startColumn][maxMoves] = ((helper(m,n,maxMoves-1,startRow+1,startColumn,dp)%mod + 
               helper(m,n,maxMoves-1,startRow-1,startColumn,dp)%mod)%mod +
               (helper(m,n,maxMoves-1,startRow,startColumn+1,dp)%mod +
               helper(m,n,maxMoves-1,startRow,startColumn-1,dp)%mod)%mod)%mod;
    }
}