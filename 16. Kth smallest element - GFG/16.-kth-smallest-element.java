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
        int low=0,high=n-1,index=-1;
        
        while(low<=high){
            index=partition(arr,low,high);
            if(index==(k-1)) return arr[index];
            else if(index>(k-1)) high=index-1;
            else low=index+1;
        }
        return -1;
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high],index=low-1;
        
        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                index++;
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
            }
        }
        index++;
        int temp=arr[high];
        arr[high]=arr[index];
        arr[index]=temp;
        
        return index;
    }
}
