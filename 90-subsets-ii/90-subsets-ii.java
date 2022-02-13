class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls=new ArrayList<>();
        helper(nums,0,ls,new ArrayList<>());
        return ls;
    }
    
    public void helper(int[] nums,int index,List<List<Integer>> ls,List<Integer> curr){
        
        ls.add(new ArrayList<>(curr));
        
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])
                continue;
        
            curr.add(nums[i]);
            helper(nums,i+1,ls,curr);
            curr.remove(curr.size()-1);
        }
    }
}