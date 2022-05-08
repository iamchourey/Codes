// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    class Pair implements Comparable<Pair>{
        int val,idx;
        
        public Pair(int v,int i){
            this.val=v;
            this.idx=i;
        }
        
        @Override
        public int compareTo(Pair p){
            return this.val-p.val;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n=nums.length;
        Pair arr[]=new Pair[n];
        
        for(int i=0;i<n;i++){
            arr[i]=new Pair(nums[i],i);
        }
        
        Arrays.sort(arr);
        int res=0;
        boolean visited[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i] || i==arr[i].idx) continue;
            
            int cycleLen=0;
            int j=i;
            while(visited[j]!=true){
                visited[j]=true;
                cycleLen++;
                j=arr[j].idx;
            }
            
            res+=cycleLen-1;
        }
        
        return res;
    }
}