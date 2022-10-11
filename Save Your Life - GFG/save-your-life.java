//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String S,char x[],int b[], int n){
        //code here
        Map<Character,Integer> ascii=new HashMap<>();
        for(int i=0;i<n;i++) ascii.put(x[i],b[i]);
        int start=0,end=0,s=0,e=0;
        long sum=Integer.MIN_VALUE,max=Integer.MIN_VALUE;
        
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            int asciiValue=ascii.containsKey(c)?ascii.get(c):c;
            if(asciiValue>sum+asciiValue){
                start=i;
                end=i;
                sum=asciiValue;
            }
            else{
                sum+=asciiValue;
                end++;
            }
            
            if(max<sum){
                max=sum;
                e=end;
                s=start;
            }
        }
        return S.substring(s,e+1);
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends