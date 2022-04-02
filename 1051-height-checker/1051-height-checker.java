class Solution {
    public int heightChecker(int[] heights) {
        int count[]=new int[101];
        for(int num:heights) count[num]++;
        
        int res=0,index=0;
        for(int i=0;i<heights.length;i++){
            while(count[index]==0) index++;
            if(heights[i]!=index) res++;
            count[index]--;
        }
        return res;
    }
}