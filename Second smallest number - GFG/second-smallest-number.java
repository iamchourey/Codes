//{ Driver Code Starts
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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        if(S>=D*9) return "-1";
        
        char[] digits=new char[D];
        S-=1;
        for(int i=D-1;i>0;i--){
            if(S>=9){
                digits[i]=(char)('0'+9);
                S-=9;
            }
            else{
                digits[i]=(char)('0'+S);
                S-=S;
            }
        }
        digits[0]=(char)('0'+1+S);
        
        int index=0;
        while(index<D && digits[index]!='9') index++;
        if(index==D) index=D-1;
        digits[index]--;
        digits[index-1]++;
        
        return new String(digits);
    }
}