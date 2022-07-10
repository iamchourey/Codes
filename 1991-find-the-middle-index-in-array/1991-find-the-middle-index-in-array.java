class Solution {
    public int findMiddleIndex(int[] nums) {
        int []pre=new int[nums.length];
        
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=nums[i]+pre[i-1];
        }
        
        int res=-1;
        
        for(int i=0;i<nums.length;i++){
            if(i==0 && (pre[nums.length-1]-pre[0])==0) return 0;
            else if(i==nums.length-1 && pre[nums.length-2]==0) return nums.length-1;
            else if(i>0 && i<nums.length-1){
                if(pre[i-1]==(pre[nums.length-1]-pre[i])) return i;
            }
        }
        return -1;
    }
}