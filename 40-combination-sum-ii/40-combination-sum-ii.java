class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ls=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,ls,new ArrayList<Integer>(),target,0);
        return ls;
    }
    
    public void helper(int candidates[],List<List<Integer>> ls,List<Integer> curr,int target,int index){
        
        if(target<0)
            return;
        
        if(target==0){
            ls.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])continue;
            curr.add(candidates[i]);
            helper(candidates,ls,curr,target-candidates[i],i+1);
            curr.remove(curr.size()-1);
        }
    }
}