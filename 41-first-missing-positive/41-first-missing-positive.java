class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n=nums.length;
        boolean containsN=false;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]==n) containsN=true;
            if(nums[i]<0) nums[i]=n;
        }
        for(int i=0;i<n;i++){
            if(Math.abs(nums[i])<n && !set.contains(Math.abs(nums[i]))){
                nums[Math.abs(nums[i])]*=-1;
                set.add(Math.abs(nums[i]));
            }
        }
        for(int i=1;i<n;i++){
            if(nums[i]>=0 && !set.contains(i)) return i;
        }
        return containsN?n+1:n;
    }
}