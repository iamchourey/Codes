//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        int result=0,prevNeg=-1,prevZero=-1,negatives=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negatives++;
                if(prevNeg==-1) prevNeg=i; 
            }
            if(arr[i]==0){
                prevNeg=-1;
                prevZero=i;
                negatives=0;
            }
            else{
                if(negatives%2==0) result=Math.max(result,i-prevZero);
                else result=Math.max(result,i-prevNeg);
            }
        }
        return result;
    }
   
}