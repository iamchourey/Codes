class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closest=Integer.MAX_VALUE;
        int sumOfThree=0;
        
        for(int first=0;first<nums.length-2;first++){
            int second=first+1;
            int end=nums.length-1;
            
            while(second<end){
                int sum=nums[first]+nums[second]+nums[end];
                if(Math.abs(target-sum)<closest) {
                    sumOfThree=sum;
                    closest=Math.abs(target-sum);
                }
                if(sum>target) end--;
                else second++;
            }
        }
        return sumOfThree;
    }
}