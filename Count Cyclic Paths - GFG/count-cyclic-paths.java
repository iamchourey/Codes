//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		if(N==0 || N==1) return 0;
		int mod=(int)1e9+7;
		boolean negative=false;
		long prev=0;
		long result=0;
		for(int i=2;i<=N;i++){
		    if(negative) result=(prev*3-3)%mod;
		    else result=(prev*3+3)%mod;
		    prev=result;
		    negative=!negative;
		}
		return (int)result%mod;
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends