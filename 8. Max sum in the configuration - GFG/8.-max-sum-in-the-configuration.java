// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
	// Your code here
	int sum=0,s0=0,res=Integer.MIN_VALUE;
	
	for(int i=0;i<n;i++){
	    sum+=A[i];
	    s0+=A[i]*i;
	}
	res=s0;
	for(int i=0;i<n;i++){
	    int s1=s0+sum-A[n-1-i]*n;
	    res=Math.max(res,s1);
	    s0=s1;
	}
	
	return res;
    }	
}
