class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int sum=0,prev=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(set.contains(sum%k)) return true;
            sum%=k;
            set.add(prev);
            prev=sum;
        }
        return false;
    }
}