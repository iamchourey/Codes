//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        int n=str.length();
        int[] lower=new int[26];
        int[] upper=new int[26];
        
        for(char c:str.toCharArray()){
            if((c-'a')>=0 && (c-'a')<26) lower[c-'a']++;
            else upper[c-'A']++;
        }
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<n;k++){
            char ch=str.charAt(k);
            while(i<26 && lower[i]==0) i++;
            while(j<26 && upper[j]==0) j++;
            if((ch-'a')>=0 && (ch-'a')<26){
                sb.append((char)(i+'a'));
                lower[i]--;
            }else{
                sb.append((char)(j+'A'));
                upper[j]--;
            }
        }
        return sb.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends