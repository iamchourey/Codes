class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int m=heights.length,n=heights[0].length;
        boolean visited[][]=new boolean[m][n];
        boolean dp[][]=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean bothOceans[]=new boolean[2];
                dfs(heights,m,n,i,j,bothOceans,visited,dp);
                if(bothOceans[0] && bothOceans[1]){
                    dp[i][j]=true;
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] heights,int m,int n,int x,int y,boolean[] bothOceans,boolean[][] visited,boolean[][] dp){
        if(dp[x][y]){
            bothOceans[0]=true;
            bothOceans[1]=true;
            return;
        }
        if(x<0 || y<0 || x>=m || y>=n || visited[x][y] || (bothOceans[0] && bothOceans[1])) return;
        if(x==0 || y==0) bothOceans[0]=true;
        if(x==m-1 || y==n-1) bothOceans[1]=true;
        visited[x][y]=true;
        if(x>0 && heights[x-1][y]<=heights[x][y]) dfs(heights,m,n,x-1,y,bothOceans,visited,dp);
        if(y>0 && heights[x][y-1]<=heights[x][y]) dfs(heights,m,n,x,y-1,bothOceans,visited,dp);
        if(x<m-1 && heights[x+1][y]<=heights[x][y]) dfs(heights,m,n,x+1,y,bothOceans,visited,dp);
        if(y<n-1 && heights[x][y+1]<=heights[x][y]) dfs(heights,m,n,x,y+1,bothOceans,visited,dp);
        visited[x][y]=false;
    }
}