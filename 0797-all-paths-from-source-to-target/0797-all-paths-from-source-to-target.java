class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        helper(graph,new ArrayList<>(),res,0,graph.length-1);
        return res;
    }
    public void helper(int[][] graph,List<Integer> curr,List<List<Integer>> res,int node,int dest){
        curr.add(node);
        if(node==dest){
            res.add(curr);
            return;
        }
        for(int i=0;i<graph[node].length;i++){
            helper(graph,new ArrayList<>(curr),res,graph[node][i],dest);
        }
    }
}