// { Driver Code Starts
//Initial Template for Java


// Java implementation of the approach 
import java.util.Arrays; 
import java.util.*;
class GFG { 

	// Driver code 
	public static void main(String[] args) 
	{ 
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        int height[]=new int[n];
	        for(int i=0;i<n;i++)
	        height[i]=sc.nextInt();
	        Solution ob = new Solution();
	        System.out.println(ob.maxWater(height, n)); 
	    }
	

		
	} 
} 
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return the maximum water that can be stored.
    static int maxWater(int height[], int n) 
    { 
        //Your code here
        int start=0,end=n-1,maxHigh=Integer.MIN_VALUE,res=Integer.MIN_VALUE;
        while(start<end){
            int high=Math.min(height[start],height[end]);
            maxHigh=Math.max(maxHigh,high);
            res=Math.max(res,maxHigh*(end-start-1));
            
            if(height[start]<height[end]) start++;
            else end--;
        }
        
        return res;
    } 

}