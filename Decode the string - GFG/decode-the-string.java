//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c!=']') stack.push(c);
            else{
                StringBuilder sb=new StringBuilder();
                while(stack.isEmpty()==false && stack.peek()>='a' && stack.peek()<='z'){
                    sb.insert(0,stack.pop());
                }
                String str=sb.toString();
                sb=new StringBuilder();
                stack.pop();
                while(stack.isEmpty()==false && Character.isDigit(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                int count=Integer.valueOf(sb.toString());
                while(count>0){
                    for(char ch:str.toCharArray()) stack.push(ch);
                    count--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(stack.isEmpty()==false) sb.insert(0,stack.pop());
        return sb.toString();
    }
}