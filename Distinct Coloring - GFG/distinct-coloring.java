//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static long distinctColoring(int N, int[]red, int[]green, int[]blue){
        //code here
        long[][] dp=new long[N][3];
        for(int i=0;i<3;i++){
            if(i==0) dp[0][i]=red[0];
            if(i==1) dp[0][i]=green[0];
            if(i==2) dp[0][i]=blue[0];
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==0) dp[i][j]=red[i]+Math.min(dp[i-1][1],dp[i-1][2]);
                else if(j==1) dp[i][j]=green[i]+Math.min(dp[i-1][0],dp[i-1][2]);
                else dp[i][j]=blue[i]+Math.min(dp[i-1][1],dp[i-1][0]);
            }
        }
        long result=Long.MAX_VALUE;
        for(int i=0;i<3;i++) result=Math.min(result,dp[N-1][i]);
        
        return result;
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends