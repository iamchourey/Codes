class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int prev=nums[0],modify=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=prev) prev=nums[i];
            else{
                modify++;
                if(modify>1) break;
            }
        }
        if(modify<=1) return true;
        
        int next=nums[nums.length-1];
        modify=0;
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=next) next=nums[i];
            else{
                modify++;
                if(modify>1) break;
            }
        }
        if(modify<=1) return true;
        
        return false;
    }
}