class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int res[]=new int[1];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int[] curr=new int[1];
                    dfs(grid,i,j,curr);
                    res[0]=Math.max(res[0],curr[0]);
                }
            }
        }
        return res[0];
    }
    
    public void dfs(int[][] grid,int x,int y,int res[]){
        
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0) return;
        
        grid[x][y]=0;
        res[0]++;
        
        dfs(grid,x+1,y,res);
        dfs(grid,x,y+1,res);
        dfs(grid,x-1,y,res);
        dfs(grid,x,y-1,res);
        
    }
}