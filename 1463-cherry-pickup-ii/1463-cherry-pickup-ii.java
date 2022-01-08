class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        
        int res=solution(grid,0,0,0,m-1,n,m,new Integer[n][m][n][m]);
        return res<0?0:res;
    }
    
    public int solution(int [][] grid,int r1,int c1,int r2,int c2,int n ,int m,Integer dp[][][][]){
        
        if(r1>=n || r2>=n || c1>=m || c2>=m || r1<0 || r2<0 || c1<0 || c2<0)
            return Integer.MIN_VALUE;
        
        if(dp[r1][c1][r2][c2]!=null)
            return dp[r1][c1][r2][c2];
        
        if(r1==n-1 && r2==n-1){
            if(c1==c2)
                return grid[r1][c1];
            else
                return grid[r1][c1]+grid[r2][c2];
        }
        
        int cherry=(r1==r2 && c1==c2)?grid[r1][c1]:grid[r1][c1]+grid[r2][c2];
        
        
        int temp[]=new int[9];
        
        temp[0]=solution(grid,r1+1,c1-1,r2+1,c2-1,n,m,dp);
        temp[1]=solution(grid,r1+1,c1-1,r2+1,c2,n,m,dp);
        temp[2]=solution(grid,r1+1,c1-1,r2+1,c2+1,n,m,dp);
        temp[3]=solution(grid,r1+1,c1,r2+1,c2-1,n,m,dp);
        temp[4]=solution(grid,r1+1,c1,r2+1,c2,n,m,dp);
        temp[5]=solution(grid,r1+1,c1,r2+1,c2+1,n,m,dp);
        temp[6]=solution(grid,r1+1,c1+1,r2+1,c2-1,n,m,dp);
        temp[7]=solution(grid,r1+1,c1+1,r2+1,c2,n,m,dp);
        temp[8]=solution(grid,r1+1,c1+1,r2+1,c2+1,n,m,dp);
        
        dp[r1][c1][r2][c2]=cherry+max(temp);
        return dp[r1][c1][r2][c2];
    }
    
    public int max(int[] temp){
        int max=Integer.MIN_VALUE;
        
        for(int num:temp){
            max=Math.max(max,num);
        }
        
        return max;
    }
}