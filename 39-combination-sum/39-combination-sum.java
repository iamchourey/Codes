class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ls=new ArrayList<>();
        helper(candidates,target,ls,new ArrayList<>(),0);
        return ls;
    }
    
    public void helper(int[] candidates,int target, List<List<Integer>> ls,List<Integer> curr,int index){
        
        if(target<0)
            return;
        
        if(target==0){
            if(!ls.contains(curr))
                ls.add(new ArrayList<>(curr));
        }
        
        for(int i=index;i<candidates.length;i++){
            curr.add(candidates[i]);
            helper(candidates,target-candidates[i],ls,curr,i);
            curr.remove(curr.size()-1);
        }
    }
}