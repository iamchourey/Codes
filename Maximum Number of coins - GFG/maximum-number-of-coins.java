//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		Integer dp[][]=new Integer[N+1][N+1];
		return helper(0,N-1,N,arr,dp);
	}
	
	public int helper(int i,int j,int N,ArrayList<Integer> arr,Integer[][] dp){
	    if(i>j) return 0;
	    if(dp[i][j]!=null) return dp[i][j];
	    int res=Integer.MIN_VALUE;
	    for(int index=i;index<=j;index++){
	        int left=(i==0)?1:arr.get(i-1);
	        int right=(j==N-1)?1:arr.get(j+1);
	        int cost=arr.get(index)*left*right + helper(i,index-1,N,arr,dp) + helper(index+1,j,N,arr,dp);
	        
	        res=Math.max(res,cost);
	    }
	    return dp[i][j]=res;
	}
}