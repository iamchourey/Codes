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
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		if(costs.length==0) return 0; 
		if(costs.length==1 && costs[0].length==1) return costs[0][0];
		if(costs[0].length<=1) return -1;
		int min=Integer.MAX_VALUE,smin=Integer.MAX_VALUE;
		
		for(int i=0;i<costs[0].length;i++){
		    if(min>costs[0][i]){
		        smin=min;
		        min=costs[0][i];
		    }
		    else if(smin>costs[0][i]){
		        smin=costs[0][i];
		    }
		}
		for(int j=1;j<costs.length;j++){
		    for(int k=0;k<costs[j].length;k++){
		        if(costs[j-1][k]==min) costs[j][k]+=smin;
		        else costs[j][k]+=min;
		    }
		    min=Integer.MAX_VALUE;
		    smin=Integer.MAX_VALUE;
		    for(int i=0;i<costs[j].length;i++){
		    if(min>costs[j][i]){
		        smin=min;
		        min=costs[j][i];
		    }
		    else if(smin>costs[j][i]){
		        smin=costs[j][i];
		    }
		}
		}
		return min;
	}
}