class Solution {
    class Pair{
        int[] arr;
        int dist;
        public Pair(int[] arr,int dist){
            this.arr=arr;
            this.dist=dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int result=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p1.dist-p2.dist;
            }
        });
        Set<Integer> set=new HashSet<>();
        set.add(0);
        getDistances(points,0,pq,set);
        int count=0;
        
        while(count!=points.length-1){
            Pair p=pq.poll();
            int dist=p.dist;
            int[] temp=p.arr;
            if(set.contains(temp[1])) continue;
            result+=dist;
            count++;
            set.add(temp[1]);
            getDistances(points,temp[1],pq,set);
        }
        return result;
    }
    public void getDistances(int[][] points,int index,PriorityQueue<Pair> pq,Set<Integer> set){
        for(int i=0;i<points.length;i++){
            if(i!=index && !set.contains(i)){
                int dist=Math.abs(points[index][0]-points[i][0])+Math.abs(points[index][1]-points[i][1]);
                pq.add(new Pair(new int[]{index,i},dist));
            }
        }
    }
}