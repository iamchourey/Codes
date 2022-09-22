class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length(),length=1,start=0;
        boolean dp[][]=new boolean[n][n];
        
        for(int gap=0;gap<n;gap++){
            for(int i=0;i<n-gap;i++){
                int j=i+gap;
                if(gap==0) dp[i][j]=true;
                else if(gap==1 && s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;
                
                if(dp[i][j] && length<(j-i+1)){
                    start=i;
                    length=j-i+1;
                }
            }
        }
        
        return s.substring(start,start+length);
    }
}