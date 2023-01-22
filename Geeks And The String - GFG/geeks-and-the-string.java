//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(stack.isEmpty()==false && stack.peek()==c) stack.pop();
            else stack.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(stack.isEmpty()==false) sb.insert(0,stack.pop());
        return sb.toString().equals("")?"-1":sb.toString();
    }
}
        
