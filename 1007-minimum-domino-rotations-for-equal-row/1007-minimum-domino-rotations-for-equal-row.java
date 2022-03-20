class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int res=Math.min(minSwaps(tops[0],tops,bottoms),minSwaps(bottoms[0],tops,bottoms));
        res=Math.min(res,minSwaps(tops[0],bottoms,tops));
        res=Math.min(res,minSwaps(bottoms[0],bottoms,tops));
        
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int minSwaps(int target,int a[],int b[]){
        int swaps=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=target && b[i]!=target) return Integer.MAX_VALUE;
            else if(a[i]!=target) swaps++;
        }
        return swaps;
    }
}