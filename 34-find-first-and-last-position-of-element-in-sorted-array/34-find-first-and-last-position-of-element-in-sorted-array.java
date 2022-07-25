class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        
        res[0]=getStartIndex(nums,target);
        res[1]=getEndIndex(nums,target);
        
        return res;
    }
    
    public int getStartIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>target) right=mid-1;
            else{
                if(mid==0 || nums[mid-1]!=target) return mid;
                else right=mid-1;
            }
        }
        return -1;
    }
    
    public int getEndIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>target) right=mid-1;
            else{
                if(mid==nums.length-1 || nums[mid+1]!=target) return mid;
                else left=mid+1;
            }
        }
        return -1;
    }
}