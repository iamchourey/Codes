class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ls=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        
        for(int i=0;i<n-3;i++){
            //if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;
            //if(nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target)continue;
            if(i>0 && nums[i]==nums[i-1])continue;
            
            for(int j=i+1;j<n-2;j++){
                //if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break;
                //if(nums[i]+nums[j]+nums[n-1]+nums[n-2]<target)continue;
                if(j>i+1 && nums[j]==nums[j-1])continue;
                
                int start=j+1,end=n-1;
                
                while(start<end){
                    int sum=nums[i]+nums[j]+nums[start]+nums[end];
                    
                    if(sum==target){
                        ls.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end && nums[start]==nums[start+1])start++;
                        while(start<end && nums[end]==nums[end-1])end--;
                        
                        start++;
                        end--;
                    }
                    else if(sum>target)
                        end--;
                    else
                        start++;
                }
            }
        }
        
        return ls;
    }
}