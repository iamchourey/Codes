class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int m=heights.length,n=heights[0].length;
        boolean dp[][]=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean[] oceans=new boolean[2];
                dfs(heights,m,n,i,j,oceans,dp,new boolean[m][n]);
                if(oceans[0]==true && oceans[1]==true){
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
    public void dfs(int[][] heights,int m,int n,int x,int y,boolean oceans[],boolean[][] dp,boolean path[][]){
        if(dp[x][y]==true){
            oceans[0]=true;
            oceans[1]=true;
            return;
        }
        if(x==0 || y==0) oceans[0]=true;
        if(x==m-1 || y==n-1) oceans[1]=true;
        if(x<0 || y<0 || x>m-1 || y>n-1 || (oceans[0]==true && oceans[1]==true)) return;
        
        path[x][y]=true;
        
        if(x>0 && heights[x-1][y]<=heights[x][y] && path[x-1][y]==false) dfs(heights,m,n,x-1,y,oceans,dp,path);
        if(x<m-1 && heights[x+1][y]<=heights[x][y] && path[x+1][y]==false) dfs(heights,m,n,x+1,y,oceans,dp,path);
        if(y>0 && heights[x][y-1]<=heights[x][y] && path[x][y-1]==false) dfs(heights,m,n,x,y-1,oceans,dp,path);
        if(y<n-1 && heights[x][y+1]<=heights[x][y] && path[x][y+1]==false) dfs(heights,m,n,x,y+1,oceans,dp,path);
        
        path[x][y]=false;
    }
}