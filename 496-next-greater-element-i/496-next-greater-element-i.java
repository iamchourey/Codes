class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int ans[]=new int[nums1.length];
        int k=0;
        for(int i=0;i<nums1.length;i++){
            int no=nums1[i];
            int index=0;
            while(nums2[index]!=no) index++;
            int j=0;
            for(j=index+1;j<nums2.length;j++){
                if(nums2[j]>no){
                    ans[k++]=nums2[j];
                    break;
                }
            }
            if(j==nums2.length) ans[k++]=-1;
        }
        return ans;
    }
}