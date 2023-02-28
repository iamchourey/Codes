//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long arr[]=ob.optimalArray(n,a);
            for(long i:arr){
                out.print(i+" ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        int[] prefix=new int[n];
        prefix[0]=a[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+a[i];
        }
        
        long[] result=new long[n];
        result[0]=0;
        
        for(int i=1;i<n;i++){
            int sum1=0,sum2=0;
            int mid=i/2;
            if(i%2!=0){
                sum1=prefix[mid];
                sum2=prefix[i]-prefix[mid];
            }
            else{
                sum1=prefix[mid-1];
                sum2=prefix[i]-prefix[mid];
            }
            result[i]=(long)(sum2-sum1);
        }
        return result;
    }
}
        
