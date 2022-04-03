class Solution {
    public int hIndex(int[] citations) {
        
        int n=citations.length;
        int count[]=new int[n+1];
        
        for(int citi:citations){
            if(citi>n) count[n]++;
            else count[citi]++;
        }
        int c=0;
        for(int i=n;i>=0;i--){
            c+=count[i];
            if(c>=i) return i;
        }
        return 0;
    }
}