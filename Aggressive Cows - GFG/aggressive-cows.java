//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        if(k==2) return stalls[stalls.length-1]-stalls[0];
        int start=1,end=stalls[stalls.length-1]-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(canAssign(n,k,stalls,mid)) start=mid+1;
            else end=mid-1;
        }
        return end;
    }
    public static boolean canAssign(int n,int k,int[] stalls,int dist){
        int count=1,last=stalls[0];
        for(int i=1;i<n;i++){
            if((stalls[i]-last)>=dist){
                count++;
                last=stalls[i];
            }
        }
        return count>=k;
    }
}