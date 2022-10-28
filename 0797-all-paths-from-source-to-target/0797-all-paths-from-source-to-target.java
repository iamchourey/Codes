class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        helper(graph,curr,res,0,graph.length-1);
        return res;
    }
    public void helper(int[][] graph,List<Integer> curr,List<List<Integer>> res,int node,int dest){
        if(node==dest){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<graph[node].length;i++){
            curr.add(graph[node][i]);
            helper(graph,curr,res,graph[node][i],dest);
            curr.remove(curr.size()-1);
        }
    }
}