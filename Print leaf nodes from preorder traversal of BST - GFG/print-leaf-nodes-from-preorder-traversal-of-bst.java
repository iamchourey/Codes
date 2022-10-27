//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
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
    public int[] leafNodes(int preorder[], int n)
    {
        // code here
        Stack<Integer> s = new Stack<Integer> ();
        ArrayList<Integer> ls=new ArrayList<>();
    for (int i = 0, j = 1; j < n; i++, j++)
    {
        boolean found = false;
 
        if (preorder[i] > preorder[j])
            s.push(preorder[i]);
 
        else
        {
            while (!s.isEmpty())
            {
                if (preorder[j] > s.peek())
                {
                    s.pop();
                    found = true;
                }
                else
                    break;
            }
        }
 
        if (found)
            ls.add(preorder[i]);
    }
    ls.add(preorder[n-1]);
    
    int[] result=new int[ls.size()];
    int index=0;
    for(int leaf:ls){
        result[index++]=leaf;
    }
    return result;
    }
    
}