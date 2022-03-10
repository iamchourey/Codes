class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Set<Integer> hs=new HashSet<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
            hs.add(arr[i]);
        }
        if((max-min)%(n-1)!=0) return false;
        
        int cd=(max-min)/(n-1);
        if(cd==0) return true;
        while(min<=max){
            if(!hs.contains(min)) return false;
            min+=cd;
        }
        return true;
    }
}