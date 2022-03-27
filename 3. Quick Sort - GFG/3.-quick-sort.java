// { Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low>=high) return;
        
        int p=partition(arr,low,high);
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int index=low-1,pivot=arr[high];
        
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
