class Solution {
    public int maxArea(int[] height) {
        
        int res=0,water=0;
        
        int start=0,end=height.length-1;
        
        res=(end-start)*Math.min(height[start],height[end]);
        
        while(start<end)
        {
            if(height[start]<height[end])
                start++;
            else if(height[start]>height[end])
                --end;
            else{
                start++;
                end--;
            }
            
            water=Math.min(height[start],height[end])*(end-start);
            
            res=Math.max(res,water);
        }
        
        return res;
    }
}