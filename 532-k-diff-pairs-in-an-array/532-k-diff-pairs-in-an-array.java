class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int res=0;
        
        Map<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            if(hs.containsKey(k+nums[i]) && hs.get(k+nums[i])!=i){
                res++;
                hs.remove(k+nums[i]);
            }
        }
        
        return res;
    }
}