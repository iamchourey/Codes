class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
            max=Math.max(max,nums[i]);
        
        if(max==1)
            return nums.length;
        
        int freq[]=new int[max+1];
        
        for(int num:nums)freq[num]++;
        
        int include=0,exclude=0;
        
        for(int i=0;i<freq.length;i++){
            int inc=freq[i]*i+exclude;
            int exc=Math.max(include,exclude);
            
            include=inc;
            exclude=exc;
        }
        
        return Math.max(include,exclude);
    }
}