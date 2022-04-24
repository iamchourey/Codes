class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int val=grid[row][col];
        dfs(grid,row,col,color,val,new boolean[grid.length][grid[0].length]);
        return grid;
    }
    
    public void dfs(int[][] grid, int row, int col, int color,int val,boolean visited[][]){
        
        if(row<0 || col<0 || row==grid.length || col==grid[0].length || grid[row][col]!=val || visited[row][col]){
            return;
        }
        boolean border=false;
        if(row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1 || grid[row-1][col]!=val 
          || grid[row+1][col]!=val || grid[row][col-1]!=val || grid[row][col+1]!=val){
            border=true;
        }
        visited[row][col]=true;
        
        dfs(grid,row+1,col,color,val,visited);
        dfs(grid,row-1,col,color,val,visited);
        dfs(grid,row,col+1,color,val,visited);
        dfs(grid,row,col-1,color,val,visited);
        
        if(border) grid[row][col]=color;
    }
}