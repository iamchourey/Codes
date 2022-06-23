class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int res=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        
        for(int no=0;no<routes.length;no++){
            int[] route=routes[no];
            for(int i=0;i<route.length;i++){
                if(!map.containsKey(route[i])) map.put(route[i],new ArrayList<>());
                map.get(route[i]).add(no);
            }
        }
        
        q.add(source);
        Set<Integer> visitedStops=new HashSet<>();
        visitedStops.add(source);
        boolean visitedBus[]=new boolean[routes.length];
        while(q.isEmpty()==false){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                if(curr==target) return res;
                List<Integer> buses=map.get(curr);
                for(int bus:buses){
                    if(visitedBus[bus]==false){
                        visitedBus[bus]=true;
                        for(int stops=0;stops<routes[bus].length;stops++){
                            if(!visitedStops.contains(routes[bus][stops])){
                                visitedStops.add(routes[bus][stops]);
                                q.add(routes[bus][stops]);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}