class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return helper(1,n,dp);
    }
    public int helper(int start,int end,int[][] dp){
        if(start>=end) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        int ans=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            int lower=i+helper(start,i-1,dp);
            int higher=i+helper(i+1,end,dp);
            int max=Math.max(lower,higher);
            ans=Math.min(ans,max);
        }
        return dp[start][end] = ans;
    }
}