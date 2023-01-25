//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minOperation(String s) {
        // code here
        int len=0,result=0;
        String curr="";
        for(int i=0;i<s.length();i++){
            curr+=s.charAt(i);
            //System.out.println(curr+" "+s.indexOf(curr));
            if(s.substring(i+1,s.length()).indexOf(curr)==0) len=i+1;
            result++;
        }
        return (len==0)?result:result-len+1;
    }
}