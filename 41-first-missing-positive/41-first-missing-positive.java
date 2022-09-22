class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n=nums.length;
        boolean containsN=false;
        
        for(int i=0;i<n;i++){
            if(nums[i]==n) containsN=true;
            if(nums[i]<=0) nums[i]=n;
        }
        for(int i=0;i<n;i++){
            if(Math.abs(nums[i])<n && nums[Math.abs(nums[i])]>0){
                nums[Math.abs(nums[i])]*=-1;
            }
        }
        for(int i=1;i<n;i++){
            if(nums[i]>0) return i;
        }
        return containsN?n+1:n;
    }
}