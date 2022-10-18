//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        // code here 
        ArrayList<Integer> result=new ArrayList<>();
        for(int j=0;j<N;j++){
            int i=0;
            int col=j;
            while(i<N && col>=0) result.add(A[i++][col--]);
        }
        for(int i=1;i<N;i++){
            int j=N-1;
            int row=i;
            while(row<N && j>=0) result.add(A[row++][j--]);
        }
        return result;
    }
}
