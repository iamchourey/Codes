class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int dp[][][]=new int[101][21][101];
        for(int i=0;i<=100;i++){
            for(int j=0;j<=20;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = helper(0,0,0,houses,cost,m,n,target,dp);
        return ans==Integer.MAX_VALUE/2?-1:ans;
    }
    
    public int helper(int h,int color,int t,int[] houses, int[][] cost, int m, int n, int target,int dp[][][]){
        
        if(t>target){
            return Integer.MAX_VALUE/2;
        }
        if(h==m){
            if(target==t) return 0;
            else return Integer.MAX_VALUE/2;
        }
        
        if(dp[h][color][t]!=-1) return dp[h][color][t];
        
        int ans=Integer.MAX_VALUE/2;
        if(houses[h]==0){
            for(int i=0;i<n;i++){
                ans=Math.min(ans,cost[h][i]+helper(h+1,i+1,(i+1==color)?t:t+1,houses,cost,m,n,target,dp));
            }
        }
        else{
            ans=Math.min(ans,helper(h+1,houses[h],(houses[h]==color)?t:t+1,houses,cost,m,n,target,dp));
        }
        
        return dp[h][color][t]=ans;
    }
}