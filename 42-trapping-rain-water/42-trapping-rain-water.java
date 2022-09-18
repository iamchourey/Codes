class Solution {
    public int trap(int[] height) {
        
        int low=1,high=height.length-2;
        int lmax=height[0],rmax=height[height.length-1];
        int water=0;
        while(low<=high){
            if(lmax<rmax){
                lmax=Math.max(lmax,height[low]);
                water+=lmax-height[low];
                low++;
            }
            else{
                rmax=Math.max(rmax,height[high]);
                water+=rmax-height[high];
                high--;
            }
        }
        return water;
    }
}