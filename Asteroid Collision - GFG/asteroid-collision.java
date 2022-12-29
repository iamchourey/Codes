//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<N;i++){
            int curr=asteroids[i];
            boolean equal=false;
            while(!stack.isEmpty() && (stack.peek()>0 && curr<0)){
                int ast=stack.pop();
                if(Math.abs(ast)==Math.abs(curr)){
                    equal=true;
                    break;
                }
                else if(Math.abs(ast)>Math.abs(curr)) curr=ast;
                else curr=curr;
            }
            if(!equal) stack.push(curr);
        }
        int res[]=new int[stack.size()];
        int index=0;
        while(stack.isEmpty()==false){
            res[index++]=stack.pop();
        }
        reverse(res,0,index-1);
        return res;
    }
    public static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            
            start++;
            end--;
        }
    }
}
