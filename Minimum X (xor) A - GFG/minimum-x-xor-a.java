//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int turnOffBits(int num,int count){
        while(num>0 && count>0){
            num=(num&(num-1));
            count--;
        }
        return num;
    }
    public static int minVal(int a, int b) {
        // code here
        int bitsa=countBits(a),bitsb=countBits(b);
        int res=0;
        if(bitsa==bitsb) return a;
        else if(bitsa>bitsb){
            return turnOffBits(a,bitsa-bitsb);
        }
        else{
            int bit=1;
            int count=bitsb-bitsa;
            for(int i=0;i<32 && count>0;i++){
                if((bit&a)==0){
                    res+=bit;
                    count--;
                }
                bit=bit<<1;
            }
        }
        return a+res;
    }
    public static int countBits(int num){
        int bits=0;
        while(num!=0){
            num=(num&(num-1));
            bits++;
        }
        return bits;
    }
}