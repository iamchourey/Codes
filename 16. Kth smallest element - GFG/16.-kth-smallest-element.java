// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        //Taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //Taking count of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking count of number elements
            int n = sc.nextInt();
            
            //taking the value of the k
            int k = sc.nextInt();
            
            //Creating an array of size n
            int arr[] = new int[n];
            
            //Inserting all the elements to the array
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            
            //calling kthSmallest method of class solve
            //and printing the result
            System.out.println(new Solution().kthSmallest(arr, n, k));
        }
        
    }
}// } Driver Code Ends



class Solution
{
    //Function to find the kth smallest element in the array.
    public static int kthSmallest(int arr[], int n, int k)
    {
        // Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++) pq.add(arr[i]);
        
        for(int i=k;i<n;i++){
            if(pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.poll();
    }
}
