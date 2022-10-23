class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result=0;
        int m=grid.length,n=grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    result=Math.max(result,dfs(grid,m,n,i,j));
                }
            }
        }
        return result;
    }
    public int dfs(int[][] grid,int m,int n,int x,int y){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==0) return 0;
        int result=1;
        grid[x][y]=0;
        result+=dfs(grid,m,n,x+1,y)+dfs(grid,m,n,x-1,y)+dfs(grid,m,n,x,y-1)+dfs(grid,m,n,x,y+1);
        return result;
    }
}