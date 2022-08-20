class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if(target==startFuel) return 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        int res=0,i=0;
        
        while(target>startFuel){
            
            while(i<stations.length && stations[i][0]<=startFuel){
                pq.add(stations[i][1]);
                i++;
            }
            
            if(pq.isEmpty()) return -1;
            
            startFuel+=pq.poll();
            res++;
        }
        return res;
    }
}