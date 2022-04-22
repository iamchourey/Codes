class Solution {
    int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        
        int m=matrix.length,n=matrix[0].length;
        int ans=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len=dfs(matrix,i,j,m,n,dp);
                ans=Math.max(ans,len);
            }
        }
        return ans;
    }
    
    public int dfs(int [][]matrix,int i,int j,int m,int n,int[][] dp){
        
        if(dp[i][j]!=0) return dp[i][j];
        int max=1;
        
        for(int[] dir:dirs){
            int x=i+dir[0],y=j+dir[1];
            if(x<0 || y<0 || x>=m || y>=n || matrix[x][y]<=matrix[i][j]) continue;
            int len=1+dfs(matrix,x,y,m,n,dp);
            max=Math.max(max,len);
        }
        
        dp[i][j]=max;
        return max;
    }
}