class Solution {
    public boolean checkPossibility(int[] nums) {
        int lis=getLis(nums);
        return nums.length-lis <=1;
    }
    
    public int getLis(int[] nums){
        int index=0;
        int[] temp=new int[nums.length];
        temp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=temp[index]){
                index++;
                temp[index]=nums[i];
            }
            else{
                int idx=binarySearch(temp,nums[i],index);
                temp[idx]=nums[i];
            }
        }
        return index+1;
    }
    public int binarySearch(int[] nums,int num,int end){
        int start=0;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=num) start=mid+1;
            else end=mid;
        }
        return end;
    }
}