//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    if(n==1) return arr[0];
	    int result[]=new int[1];
	    int sum=0;
	    for(int num:arr) sum+=num;
	    int[][] dp=new int[n][sum];
	    for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
	    result[0]=Integer.MAX_VALUE;
	    helper(arr,n,0,0,result,sum,dp);
	    return result[0];
	} 
	public static int helper(int[] arr,int n,int index,int sum,int[] result,int total,int[][] dp){
	    if(sum==total) return Integer.MAX_VALUE;
	    if(index==n){
	        result[0]=Math.min(Math.abs(total-2*sum),result[0]);
	        return result[0];
	    }
	    if(dp[index][sum]!=-1) return dp[index][sum];
	    int a=helper(arr,n,index+1,sum+arr[index],result,total,dp);
	    int b=helper(arr,n,index+1,sum,result,total,dp);
	    return dp[index][sum]=Math.min(a,b);
	}
}
