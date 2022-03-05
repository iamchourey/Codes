class Solution {
    public int longestSubarray(int[] nums) {
        
        int maxLen=0,i=0,j=0,zeroes=0;
        
        while(i<nums.length){
            
            if(nums[i]==0)
                zeroes++;
            
            if(zeroes>1)
            {
                while(j<nums.length && nums[j]!=0)
                    j++;
                
                ++j;
                
                zeroes--;
            }
            
            maxLen=Math.max(maxLen,i-j+1);
            ++i;
        }
        
        if(maxLen==nums.length && zeroes==0)
            return nums.length-1;
        
        return maxLen-1;
    }
}