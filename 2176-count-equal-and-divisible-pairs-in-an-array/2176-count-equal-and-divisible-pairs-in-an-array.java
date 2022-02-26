class Solution {
    public int countPairs(int[] nums, int k) {
        
        int ans=0;
        Map<Integer,List<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(hm.containsKey(nums[i])){
                List<Integer> curr=hm.get(nums[i]);
                for(int index:curr){
                    if((index*i)%k==0)
                        ans++;
                }
            }
            else{
                hm.put(nums[i],new ArrayList<Integer>());
            }
            hm.get(nums[i]).add(i);
        }
        return ans;
    }
}