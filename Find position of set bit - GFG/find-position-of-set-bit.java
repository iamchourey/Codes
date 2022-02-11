// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findPosition(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int n) {
        // code here
        
        if((n&(n-1)) != 0)
        return -1;
        
        int pos=1,mask=1;
        
        for(int i=0;i<32;i++){
            if((mask&n)!=0)
            return pos;
            
            mask=mask<<1;
            pos++;
        }
        
        return -1;
    }
};