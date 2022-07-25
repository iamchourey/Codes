class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int res[]=new int[2];
        int index=0;
        
        res[0]=-1;
        res[1]=-1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res[index++]=i;
                while(i<nums.length && nums[i]==target) i++;
                res[index]=i-1;
                
                break;
            }
        }
        return res;
    }
}