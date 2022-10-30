//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int n)
    {
        int size = Math.max(n+1, 7);
    long []dp = new long[size];
 
    dp[0] = 0;
    dp[1] = 1;
 
    // Every day current population
    // will be three times of the previous day
    for (int i = 2; i <= 6; i++) {
        dp[i] = dp[i - 1] * 3;
    }
    if(n<=6) return dp[n];
    // Manually calculated value
    dp[7] = 726;
 
    // From 8th day onwards
    for (int i = 8; i <= n; i++) {
 
        // Chick population decreases by 2/3 everyday.
        // For 8th day on [i-6] i.e 2nd day population
        // was 3 and so 2 new born die on the 6th day
        // and so on for the upcoming days
        dp[i] = (dp[i - 1] - (2 * dp[i - 6] / 3)) * 3;
    }
 
    return dp[n];
    }
}