class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls=new ArrayList<>();
        helper(nums,0,ls,new ArrayList<>());
        return ls;
    }
    
    public void helper(int[] nums,int index,List<List<Integer>> ls,List<Integer> curr){
        
        if(index==nums.length){
            if(!ls.contains(curr)){
                ls.add(new ArrayList<>(curr));
            }
            return;
        }
        helper(nums,index+1,ls,curr);
        curr.add(nums[index]);
        helper(nums,index+1,ls,curr);
        curr.remove(curr.size()-1);
    }
}