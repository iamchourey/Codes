// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] a, int n, int s) 
    {
        // Your code here
        int start=0,end=0,sum=a[start];
        ArrayList<Integer> ls=new ArrayList<>();
        while(end<n){
            if(sum<s){
                end++;
                if(end<n) sum+=a[end];
            }else if(sum>s){
                sum-=a[start];
                start++;
            }else{
                ls.add(start+1);
                ls.add(end+1);
                break;
            }
        }
        
        if(ls.size()==0) ls.add(-1);
        return ls;
    }
}