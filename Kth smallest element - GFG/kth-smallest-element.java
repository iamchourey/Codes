//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int K) 
    { 
        //Your code here
        if (K > 0 && K <= r - l + 1) {
            int pos = partition(arr, l, r);
 
            if (pos - l == K - 1)
                return arr[pos];
 
            if (pos - l > K - 1)
                return kthSmallest(arr, l, pos - 1, K);
 
            return kthSmallest(arr, pos + 1, r,
                               K - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    } 
    
    public static int partition(int[] arr, int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
 
                // Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
                i++;
            }
        }
 
        // Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
 
        return i;
    }
}
