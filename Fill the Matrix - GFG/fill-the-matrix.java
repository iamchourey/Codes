//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		if(N==1 && M==1) return 0;
		int ones=1;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[]{x,y});
		boolean[][] visited=new boolean[N+1][M+1];
		visited[x][y]=true;
		int steps=0;
		int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
		while(q.isEmpty()==false){
		    int size=q.size();
		    steps++;
		    while(size-->0){
		        int[] curr=q.poll();
		        int i=curr[0];
		        int j=curr[1];
		        for(int dir[]:dirs){
		            int r=i+dir[0];
		            int c=j+dir[1];
		            if(r>0 && c>0 && r<=N && c<=M && !visited[r][c]){
		                visited[r][c]=true;
		                ones++;
		                q.add(new int[]{r,c});
		            }
		        }
		    }
		    if(ones==N*M) return steps;
		}
		return -1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends