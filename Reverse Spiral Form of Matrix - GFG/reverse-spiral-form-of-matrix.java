//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
        int[] result=new int[R*C];
        int left=0,right=C-1,top=0,bottom=R-1;
        int index=0;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                result[index++]=a[top][i];
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[index++]=a[i][right];
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                result[index++]=a[bottom][i];
               }
               bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                result[index++]=a[i][left];
                }
               left++;
            }
        }
        reverse(result,0,result.length-1);
        return result;
    }
    public static void reverse(int[] result,int start,int end){
        while(start<end){
            int temp=result[start];
            result[start]=result[end];
            result[end]=temp;
            
            start++;
            end--;
        }
    }
}