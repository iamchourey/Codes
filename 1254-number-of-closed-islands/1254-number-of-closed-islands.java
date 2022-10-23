class Solution {
    public int closedIsland(int[][] grid) {
        int result=0;
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    boolean[] closed=new boolean[1];
                    closed[0]=true;
                    dfs(grid,i,j,m,n,closed);
                    if(closed[0]) result++;
                }
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int x,int y,int m,int n,boolean[] closed){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==1) return;
        grid[x][y]=1;
        if(x==0 || y==0 || x==m-1 || y==n-1) closed[0]=false;
        dfs(grid,x+1,y,m,n,closed);
        dfs(grid,x-1,y,m,n,closed);
        dfs(grid,x,y-1,m,n,closed);
        dfs(grid,x,y+1,m,n,closed);
    }
}