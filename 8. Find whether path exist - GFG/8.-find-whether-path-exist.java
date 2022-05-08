// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j,n,new boolean[n][n]);
                }
            }
        }
        return false;
    }
    public static boolean dfs(int[][] grid,int x,int y,int n,boolean[][] visited){
        if(x<0 || x>=n || y<0 || y>=n || grid[x][y]==0 || visited[x][y]) return false;
        if(grid[x][y]==2) return true;
        
        visited[x][y]=true;
        
        return dfs(grid,x+1,y,n,visited) || dfs(grid,x,y+1,n,visited) || dfs(grid,x-1,y,n,visited) || dfs(grid,x,y-1,n,visited);
    }
}