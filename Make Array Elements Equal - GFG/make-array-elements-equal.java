//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        // Code here
        if(N%2==0){
            int middle=N/2;
            long element=(long)middle*2L;
            long n=element/2L;
            return element*(element-1)/2L - 2L*n*(n-1L)/2L;
        }
        else{
            int middle=N/2;
            long element=(long)middle*2L+1L;
            long n=element/2L;
            return 2L*n*(n+1L)/2L;
        }
    }
}