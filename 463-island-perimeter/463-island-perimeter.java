class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int perimeter[]=new int[1];
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(grid,i,j,perimeter);
                    break;
                }
            }
        }
        return perimeter[0];
    }
    
    public void dfs(int[][] grid,int i,int j,int[] perimeter)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            perimeter[0]++;
            return;
        }
        
        if(grid[i][j]==-1)
            return;
        
        grid[i][j]=-1;
        
        dfs(grid,i+1,j,perimeter);
        dfs(grid,i,j+1,perimeter);
        dfs(grid,i,j-1,perimeter);
        dfs(grid,i-1,j,perimeter);
    }
}