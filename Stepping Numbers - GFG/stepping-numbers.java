//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        // code here
        int result[]=new int[1];
        if(n==0) result[0]++;
        for(int i=1;i<=9;i++){
            steppings(n,m,i,result);
        }
        return result[0];
    }
    public void steppings(int n,int m,int curr,int[] res){
        if(Integer.valueOf(curr)>m) return;
        if(curr>=n && curr<=m) res[0]++;
        
        int lastDigit=curr%10;
        if(lastDigit!=0) steppings(n,m,curr*10+lastDigit-1,res);
        if(lastDigit!=9) steppings(n,m,curr*10+lastDigit+1,res);
    }
}
