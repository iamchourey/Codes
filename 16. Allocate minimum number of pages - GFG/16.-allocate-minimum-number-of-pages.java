// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int max=Integer.MIN_VALUE,sum=0;
        for(int a:A){
            max=Math.max(a,max);
            sum+=a;
        }
        
        int low=max,high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            if(isFeasible(A,N,M,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    
    public static boolean isFeasible(int[] A,int n,int m,int ans){
        
        int sum=0,k=1;
        for(int i=0;i<n;i++){
            if((sum+A[i])>ans){
                k++;
                sum=A[i];
            }else sum+=A[i];
        }
        return (k<=m);
    }
};