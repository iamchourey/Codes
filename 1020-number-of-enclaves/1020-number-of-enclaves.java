class Solution {
    public int numEnclaves(int[][] grid) {
        int result=0;
        int m=grid.length,n=grid[0].length;
        
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1){
                    int ones[]=new int[1];
                    boolean inside[]=new boolean[1];
                    inside[0]=true;
                    dfs(grid,m,n,i,j,ones,inside);
                    result+=inside[0]==true?ones[0]:0;
                }
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int m,int n,int x,int y,int[] ones,boolean[] inside){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==0) return;
        if(x==0 || y==0 || x==m-1 || y==n-1) inside[0]=false;
        ones[0]++;
        grid[x][y]=0;
        dfs(grid,m,n,x+1,y,ones,inside);
        dfs(grid,m,n,x-1,y,ones,inside);
        dfs(grid,m,n,x,y+1,ones,inside);
        dfs(grid,m,n,x,y-1,ones,inside);
    }
}