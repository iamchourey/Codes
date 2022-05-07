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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges.
    class Node{
        int time;
        int x,y;
        
        public Node(int t,int x,int y){
            this.time=t;
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<Node> q=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        int resultTime=-1,count1=0;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Node(0,i,j));
                }
                if(grid[i][j]==1) count1++;
            }
        }
        
        while(q.isEmpty()==false){
            Node node=q.poll();
            int currTime=node.time;
            int x=node.x;
            int y=node.y;
            
            for(int[] dir:dirs){
                int newX=x+dir[0];
                int newY=y+dir[1];
                
                if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]==1){
                    q.add(new Node(currTime+1,newX,newY));
                    grid[newX][newY]=2;
                    count1--;
                }
            }
            
            resultTime=Math.max(resultTime,currTime);
        }
        if(count1!=0) return -1;
        
        return resultTime;
    }
}