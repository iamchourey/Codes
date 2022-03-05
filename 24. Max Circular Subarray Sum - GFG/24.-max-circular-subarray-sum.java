// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        int normalSum=kadane(a);
        
        if(normalSum<0)
        return normalSum;
        
        int totalSum=0;
        
        for(int i=0;i<n;i++){
            totalSum+=a[i];
            a[i]=-a[i];
        }
        
        int maxCircular=totalSum+kadane(a);
        
        return Math.max(maxCircular,normalSum);
    }
    
    public static int kadane(int[] a){
        int maxTillNow=a[0];
        int ans=a[0];
        
        for(int i=1;i<a.length;i++){
            maxTillNow=Math.max(maxTillNow+a[i],a[i]);
            ans=Math.max(ans,maxTillNow);
        }
        
        return ans;
    }
    
}

