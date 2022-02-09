class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int res=0;
        
        for(int start=0;start<nums.length-1;start++){
            
            if(start>0 && nums[start]==nums[start-1])
                continue;
            
            int i=start,j=nums.length-1;
        
           while(i<j){
              if((nums[j]-nums[i])==k){
                 res++;
                 i++;
                 j--;
                 
                 while(i<j && nums[i]==nums[i-1])
                     i++;
                 while(i<j && nums[j]==nums[j+1])
                     j--;
             }
              else if((nums[j]-nums[i])>k)
                  j--;
              else
                  i++;
           }
        }
        
        return res;
    }
}