class Solution {
    
    public int helper(int[] stoneValue,int i,int j,int dp[]){
        
        if(i>j)
            return 0;
        
        if(dp[i]!=-1)
            return dp[i];
        
        int ans=Integer.MIN_VALUE;
        
        ans=Math.max(ans,stoneValue[i]-helper(stoneValue,i+1,j,dp));
        if((i+1)<=j)
            ans=Math.max(ans,stoneValue[i]+stoneValue[i+1]-helper(stoneValue,i+2,j,dp));
        if((i+2)<=j)
            ans=Math.max(ans,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-helper(stoneValue,i+3,j,dp));
        
        return dp[i]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        
        int n=stoneValue.length-1;
        
        int[] dp=new int[n+1];
        
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        if(helper(stoneValue,0,n,dp)==0)
            return "Tie";
        else if(helper(stoneValue,0,n,dp)>0)
            return "Alice";
        else
            return "Bob";
    }
}