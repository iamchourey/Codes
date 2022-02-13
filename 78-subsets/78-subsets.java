class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ls=new ArrayList<>();
        int n=(int)Math.pow(2,nums.length);
        
        for(int i=0;i<n;i++){
            
            List<Integer> curr=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))==(1<<j))
                    curr.add(nums[j]);
            }
            ls.add(curr);
        }
        
        return ls;
    }
}