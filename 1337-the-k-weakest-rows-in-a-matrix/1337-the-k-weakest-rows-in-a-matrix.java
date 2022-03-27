class Solution {
    class soldiers{
        int soldiers;
        int index;
        
        soldiers(int sol,int i){
            this.soldiers=sol;
            this.index=i;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int res[]=new int[k];
        
        PriorityQueue<soldiers> pq=new PriorityQueue<>(new Comparator<soldiers>(){
            public int compare(soldiers s1,soldiers s2){
                if(s1.soldiers==s2.soldiers) return s1.index-s2.index;
                else return s1.soldiers-s2.soldiers;
            }
        });
        for(int i=0;i<mat.length;i++){
            int sols=0;
            for(int j=0;j<mat[i].length && mat[i][j]!=0;j++) sols++;
            pq.add(new soldiers(sols,i));
        }
        for(int idx=0;idx<k;idx++){
            res[idx]=pq.poll().index;
        }
        return res;
    }
}