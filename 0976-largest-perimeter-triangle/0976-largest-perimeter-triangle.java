class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int perimeter=Integer.MIN_VALUE;
        for(int first=0;first<nums.length-2;first++){
            int second=first+1,third=nums.length-1;
            while(second<third){
                int sum=nums[first]+nums[second]+nums[third];
                if(nums[first]+nums[second]>nums[third]){
                    perimeter=Math.max(perimeter,sum);
                    second++;
                }
                else third--;
            }
        }
        return perimeter==Integer.MIN_VALUE?0:perimeter;
    }
}