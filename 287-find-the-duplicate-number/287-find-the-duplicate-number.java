class Solution {
    public int findDuplicate(int[] nums) {
        
        int n=nums.length,left=0,right=n-1;
        
        while(left<right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int num:nums){
                if(num<=mid) count++;
            }
            
            if(count<=mid) left=mid+1;
            else right=mid;
        }
        return left;
    }
}