class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length<3)
            return 0;
        
        int dp[]=new int[nums.length];
        dp[0]=0;
        dp[1]=0;
        
        for(int i=2;i<nums.length;i++){
            if(isAP(nums[i-2],nums[i-1],nums[i]))
                dp[i]=1+dp[i-1];
        }
        
        int ans=0;
        for(int num:dp)
            ans+=num;
        
        return ans;
    }
    
    public boolean isAP(int a,int b,int c){
        if(b-a == c-b)
            return true;
        else
            return false;
    }
}