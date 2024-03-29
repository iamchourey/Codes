//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        int start=0,end=P.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(allAlternate(S,mid,P)) end=mid-1;
            else start=mid+1;
        }
        return end==-1?0:start+1;
    }
    public static boolean allAlternate(String s,int mid,int[] indexes){
        char[] chars=s.toCharArray();
        for(int i=0;i<=mid;i++){
            chars[indexes[i]]='?';
        }
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]!='?' && chars[i]==chars[i+1]) return false;
        }
        return true;
    }
}