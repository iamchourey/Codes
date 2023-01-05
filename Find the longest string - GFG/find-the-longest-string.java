//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        Set<String> set=new HashSet<>();
        for(String s:arr) set.add(s);
        
        String res="";
        for(int i=0;i<arr.length;i++){
            String curr=arr[i];
            boolean prefixes=true;
            for(int j=1;j<curr.length();j++){
                String substring=curr.substring(0,j);
                if(!set.contains(substring)) prefixes=false;
            }
            if(prefixes){
                if(curr.length()>res.length()) res=curr;
                else if(curr.length()==res.length() && curr.compareTo(res)<0) res=curr;
            }
        }
        return res;
    }
}
        
