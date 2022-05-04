// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> added=new HashSet<>();
        ArrayList<Integer> ls=new ArrayList<>();
        for(int num:arr){
            if(hs.contains(num) && !added.contains(num)){
                ls.add(num);
                added.add(num);
            }
            hs.add(num);
        }
        
        if(ls.size()==0) ls.add(-1);
        Collections.sort(ls);
        return ls;
    }
}
