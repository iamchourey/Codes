class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> hs=new HashSet<>();
        for(int num:nums) hs.add(num);
        
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]-1)){
                int curr=1;
                int temp=nums[i];
                while(hs.contains(temp+1)){
                    hs.remove(temp);
                    curr++;
                    temp++;
                }
                res=Math.max(res,curr);
            }
        }
        return res;
    }
}