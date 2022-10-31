//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    class Pair{
        int index1,index2;
        public Pair(int i1,int i2){
            this.index1=i1;
            this.index2=i2;
        }
    }
     int[] satisfyEqn(int[] A, int N) {
        // code here
        Map<Integer,Pair> map=new HashMap<>();
        int[] result=new int[4];
        Arrays.fill(result,Integer.MAX_VALUE);
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int sum=A[i]+A[j];
                if(map.containsKey(sum)){
                    Pair p=map.get(sum);
                    if(p.index1!=i && p.index2!=j && p.index1!=j && p.index2!=i){
                        int[] temp=new int[]{p.index1,p.index2,i,j};
                        if(lexicoSmall(result,temp)){
                            result=temp;
                        }
                    }
                }
                else map.put(sum,new Pair(i,j));
            }
        }
        return result[0]==Integer.MAX_VALUE?new int[]{-1,-1,-1,-1}:result;
    }
    public boolean lexicoSmall(int[] result,int[] temp){
        for(int i=0;i<4;i++){
            if(result[i]==temp[i]) continue;
            else if(result[i]>temp[i]) return true;
            else return false;
        }
        return false;
    }
};