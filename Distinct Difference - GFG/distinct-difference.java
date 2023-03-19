//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] nums) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        if(N==1){
            result.add(0);
            return result;
        }
        int[] left=new int[N];
        int[] right=new int[N];
        
        Set<Integer> set=new HashSet<>();
        left[0]=1;
        set.add(nums[0]);
        for(int i=1;i<N;i++){
            if(set.contains(nums[i])) left[i]=left[i-1];
            else{
                left[i]=1+left[i-1];
                set.add(nums[i]);
            }
        }
        set=new HashSet<>();
        right[nums.length-1]=1;
        set.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            if(set.contains(nums[i])) right[i]=right[i+1];
            else{
                right[i]=1+right[i+1];
                set.add(nums[i]);
            }
        }
        
        for(int i=0;i<N;i++){
            if(i==0) result.add(-right[i+1]);
            else if(i==N-1) result.add(left[i-1]);
            else result.add(left[i-1]-right[i+1]);
        }
        return result;
    }
}
        
