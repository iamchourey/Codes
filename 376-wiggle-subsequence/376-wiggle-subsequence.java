class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int n=nums.length;
        int up=1,down=1;
        
        for(int i=1;i<nums.length;i++){
            int nup=0,ndown=0;
            if(nums[i]>nums[i-1]){
                nup=down+1;
                ndown=down;
            }
            else if(nums[i]<nums[i-1]){
                ndown=up+1;
                nup=up;
            }
            else{
                nup=up;
                ndown=down;
            }
            
            up=nup;
            down=ndown;
        }
        return Math.max(up,down);
    }
}