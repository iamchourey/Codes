class Solution {
    class Pair{
        int plantTime,growTime;
        public Pair(int p,int g){
            this.plantTime=p;
            this.growTime=g;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Pair[] array=new Pair[plantTime.length];
        for(int i=0;i<plantTime.length;i++){
            array[i]=new Pair(plantTime[i],growTime[i]);
        }
        Arrays.sort(array,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p2.growTime-p1.growTime;
            }
        });
        
        int result=0,plant=0;
        for(int i=0;i<array.length;i++){
            plant+=array[i].plantTime;
            result=Math.max(result,plant+array[i].growTime);
        }
        return result;
    }
}