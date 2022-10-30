class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int head=-1;
        List<List<Integer>> structure=new ArrayList<>();
        for(int i=0;i<manager.length;i++){
            structure.add(new ArrayList<>());
            if(manager[i]==-1) head=i;
        }
        for(int i=0;i<manager.length;i++){
            int mgr=manager[i];
            if(mgr==-1) continue;
            structure.get(mgr).add(i);
        }
        int time=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{head,informTime[head]});
        
        while(queue.isEmpty()==false){
            int size=queue.size();
            while(size-->0){
                int[] curr=queue.poll();
                time=Math.max(time,curr[1]);
                for(int subOrd:structure.get(curr[0])){
                    queue.add(new int[]{subOrd,curr[1]+informTime[subOrd]});
                }
            }
        }
        return time;
    }
}