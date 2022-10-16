class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n=jobDifficulty.length;
        if(d>n) return -1;
        
        int[][] dp=new int[d][n];
        int max=jobDifficulty[0];
        
        for(int i=0;i<n;i++){
            max=Math.max(max,jobDifficulty[i]);
            dp[0][i]=max;
        }
        
        for(int i=1;i<d;i++){
            for(int j=i;j<n;j++){
                dp[i][j]=dp[i-1][j-1]+jobDifficulty[j];
                int maxJob=jobDifficulty[j];
                for(int k=j;k>=i;k--){
                    maxJob=Math.max(maxJob,jobDifficulty[k]);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][k-1]+maxJob);
                }
            }
        }
        return dp[d-1][n-1];
    }
}