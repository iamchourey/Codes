class Solution {
    public long appealSum(String s) {
        long appeal=0;
        int n=s.length();
        int[] lastIndex=new int[26];
        Arrays.fill(lastIndex,-1);
        int[] dp=new int[n+1];
        
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            dp[i+1]=dp[i]+i-lastIndex[c];
            lastIndex[c]=i;
            appeal+=dp[i+1];
        }
        return appeal;
    }
}