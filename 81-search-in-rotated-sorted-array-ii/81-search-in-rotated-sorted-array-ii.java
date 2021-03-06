class Solution {
    public boolean search(int[] nums, int target) {
        
        int start=0,end=nums.length-1;
        
        if(nums.length==1 && target==nums[0])
            return true;
        
        while(start<=end)
        {
            while (start<end && nums[start]==nums[start+1])start++;
            while (start<end && nums[end]==nums[end-1])end--;
            
            int mid=start+(end-start)/2;
            
            if(nums[mid]==target)
                return true;
            
            if(nums[start]<=nums[mid])
            {
                if(nums[mid]>target && nums[start]<=target)
                    end=mid-1;
                else
                    start=mid+1;
            }else{
                if(target>nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        
        return false;
    }
}