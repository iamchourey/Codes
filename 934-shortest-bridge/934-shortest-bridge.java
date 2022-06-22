class Solution {
    public int shortestBridge(int[][] grid) {
        
        int m=grid.length,n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        boolean found=false;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,m,n,visited,q);
                    found=true;
                    break;
                }
            }
            if(found) break;
        }
        
        int bridge=-1;
        int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
        while(q.isEmpty()==false){
            int size=q.size();
            bridge++;
            while(size-->0){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && !visited[x][y]){
                        if(grid[x][y]==1) return bridge;
                        grid[x][y]=1;
                        visited[x][y]=true;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        return -1;
    }
    
    public void dfs(int[][] grid,int row,int col,int m,int n,boolean visited[][],Queue<int[]> q){
        if(row<0 || col<0 || row>=m || col>=n || visited[row][col] || grid[row][col]==0) return;
        visited[row][col]=true;
        q.add(new int[]{row,col});
        dfs(grid,row+1,col,m,n,visited,q);
        dfs(grid,row-1,col,m,n,visited,q);
        dfs(grid,row,col+1,m,n,visited,q);
        dfs(grid,row,col-1,m,n,visited,q);
    }
}