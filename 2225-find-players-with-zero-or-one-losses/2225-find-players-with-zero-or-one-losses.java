class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        
        Map<Integer,Integer> winner=new HashMap<>();
        Map<Integer,Integer> loser=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        
        for(int match[]:matches){
            winner.put(match[0],winner.getOrDefault(match[0],0)+1);
            loser.put(match[1],loser.getOrDefault(match[1],0)-1);
        }
        
        for(int match[]:matches){
            if(!loser.containsKey(match[0]) && !set.contains(match[0])){
                ls1.add(match[0]);
                set.add(match[0]);
            }
            if(loser.get(match[1])==-1) ls2.add(match[1]);
        }
        Collections.sort(ls1);
        Collections.sort(ls2);
        res.add(ls1);
        res.add(ls2);
        
        return res;
    }
}