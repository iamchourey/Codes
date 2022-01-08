class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        int res=cherry(grid,0,0,0,0,n,new Integer[n][n][n][n]);
        
        return res<0?0:res;
    }
    
    public int cherry(int[][] grid,int r1,int c1,int r2,int c2,int n,Integer dp[][][][]){
        
        if(r1>=n ||r2>=n ||c1>=n ||c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1)
            return Integer.MIN_VALUE;
        
        if(dp[r1][c1][r2][c2]!=null)
            return dp[r1][c1][r2][c2];
        
        if( (r1==n-1 && c1==n-1) || (r2==n-1 && c2==n-1))
            return grid[n-1][n-1];
        
        int c=(r1==r2 && c1==c2)?grid[r1][c1]:grid[r1][c1]+grid[r2][c2];
        
        int f1=cherry(grid,r1+1,c1,r2+1,c2,n,dp);
        int f2=cherry(grid,r1+1,c1,r2,c2+1,n,dp);
        int f3=cherry(grid,r1,c1+1,r2+1,c2,n,dp);
        int f4=cherry(grid,r1,c1+1,r2,c2+1,n,dp);
        
        dp[r1][c1][r2][c2]=c+Math.max(Math.max(f1,f2),Math.max(f3,f4));
        
        return dp[r1][c1][r2][c2];
    }
}