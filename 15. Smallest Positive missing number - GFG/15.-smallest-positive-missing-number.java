// { Driver Code Starts
import java.util.*;


 // } Driver Code Ends


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int nums[], int size)
    {
        // Your code here
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length)
            nums[i]=nums.length+1;
        }
        
        for(int i=0;i<nums.length;i++){
            
            int index=Math.abs(nums[i])-1;
            if(index<nums.length && nums[index]>0)
            nums[index]=-nums[index];
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        
        return nums.length+1;
    }
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends