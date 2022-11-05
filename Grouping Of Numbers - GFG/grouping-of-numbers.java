//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxGroupSize(int[] arr, int N, int K) {
        // code here
        int[] rem=new int[K];
        for(int num:arr){
            rem[num%K]++;
        }
        int i=1,j=K-1;
        int result=(rem[0]==0)?0:1;
        while(i<=j){
            if(i==j) result+=(rem[i]==0)?0:1;
            else result+=Math.max(rem[i],rem[j]);
            i++;
            j--;
        }
        return result;
    }
};