//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length,m=grid[0].length;
        int result[][]=new int[n][m];
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
        int distance=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) queue.add(new int[]{i,j});
            }
        }
        while(queue.isEmpty()==false){
            int size=queue.size();
            distance++;
            while(size-->0){
                int[] curr=queue.poll();
                for(int[] dir:dirs){
                    int x=dir[0]+curr[0];
                    int y=dir[1]+curr[1];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0){
                        grid[x][y]=1;
                        result[x][y]=distance;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        return result;
    }
}