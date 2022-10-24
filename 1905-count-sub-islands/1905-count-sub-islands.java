class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands=0;
        int m=grid1.length,n=grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    boolean isSubIsland[]=new boolean[1];
                    isSubIsland[0]=true;
                    dfs(grid1,grid2,m,n,i,j,isSubIsland);
                    if(isSubIsland[0]) subIslands++;
                }
            }
        }
        return subIslands;
    }
    public void dfs(int[][] grid1,int[][] grid2,int m,int n,int x,int y,boolean[] isSubIsland){
        if(x<0 || y<0 || x>=m || y>=n || grid2[x][y]==0) return;
        if(grid1[x][y]!=1) isSubIsland[0]=false;
        grid2[x][y]=0;
        dfs(grid1,grid2,m,n,x+1,y,isSubIsland);
        dfs(grid1,grid2,m,n,x-1,y,isSubIsland);
        dfs(grid1,grid2,m,n,x,y-1,isSubIsland);
        dfs(grid1,grid2,m,n,x,y+1,isSubIsland);
    }
}