//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int Q = Integer.parseInt(str[1]);
			int [][] U = new int[Q][3];
			int i = 0;
			while(i < Q) {
				str = br.readLine().trim().split(" ");
				U[i][0] = Integer.parseInt(str[0]);
				U[i][1] = Integer.parseInt(str[1]);
				U[i][2] = Integer.parseInt(str[2]);
				i++;
			}
			Solution obj = new Solution();
			int [] arr = obj.updateQuery(N, Q, U);
			for(int j: arr) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int Q, int [][]U){
        //Write your code here
        int[] result=new int[N];
        int bits[]=new int[32];
        Map<Integer,List<Integer>> mapAdd=new HashMap<>();
        Map<Integer,List<Integer>> mapRemove=new HashMap<>();
        for(int[] q:U){
            int l=q[0]-1,r=q[1],x=q[2];
            if(!mapAdd.containsKey(l)) mapAdd.put(l,new ArrayList<>());
            if(!mapRemove.containsKey(r)) mapRemove.put(r,new ArrayList<>());
            
            mapAdd.get(l).add(x);
            mapRemove.get(r).add(x);
        }
        
        for(int i=0;i<N;i++){
            if(mapAdd.containsKey(i)){
                for(int val:mapAdd.get(i)){
                    int index=0;
                    while(val>0){
                        if((val&1)!=0) bits[index]++;
                        val=val>>1;
                        index++;
                    }
                }
            }
            if(mapRemove.containsKey(i)){
                for(int val:mapRemove.get(i)){
                    int index=0;
                    while(val>0){
                        if((val&1)!=0) bits[index]--;
                        val=val>>1;
                        index++;
                    }
                }
            }
            int number=0;
            for(int j=0;j<32;j++){
                if(bits[j]>0) number+=(int)Math.pow(2,j);
            }
            result[i]=number;
        }
        return result;
    }
}