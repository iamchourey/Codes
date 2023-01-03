//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        int dp[]=new int[N];
        int len=0;
        
        for(int height:H){
            if(len==0 || height>dp[len-1]){
                dp[len]=height;
                len++;
            }else{
                int index=getIndex(dp,height,len);
                dp[index]=height;
            }
        }
        return N-len;
    }
    public int getIndex(int[] dp,int height,int len){
        int start=0,end=len-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(dp[mid]<height) start=mid+1;
            else end=mid-1;
        }
        return start;
    }
};