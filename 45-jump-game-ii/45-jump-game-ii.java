class Solution {
    public int jump(int[] nums) {
        
//         int dp[]=new int[nums.length];
//         int jumps=0;
        
//         Arrays.fill(dp,21470000);
//         dp[0]=0;
        
//         for(int i=1;i<nums.length;i++)
//         {
//             for(int j=0;j<i;j++)
//             {
//                 if(nums[j]+j>=i)
//                     dp[i]=Math.min(dp[i],dp[j]+1);
//             }
//         }
        
//         return dp[nums.length-1];
        
        int jumps=0,currEnd=0,currFarthest=0;
        
        for(int i=0;i<nums.length-1;i++)
        {
            currFarthest=Math.max(currFarthest,nums[i]+i);
            
            if(i==currEnd)
            {
                jumps++;
                currEnd=currFarthest;
            }
        }
        
        return jumps;
    }
}