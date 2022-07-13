class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int res=0,start=0,prevCount=0;
        
        for(int end=0;end<nums.length;end++){
            if(nums[end]<=right && nums[end]>=left){
                prevCount=(end-start+1);
                res+=prevCount;
            }
            else if(nums[end]<left){
                res+=prevCount;
            }
            else{
                prevCount=0;
                start=end+1;
            }
        }
        return res;
    }
}