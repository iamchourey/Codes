class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum=0,running=0;
        int n=nums.length;
        long minAvg=Integer.MAX_VALUE;
        int result=-1;
        for(int num:nums) sum+=num;
        for(int i=0;i<n;i++){
            running+=nums[i];
            long remaining=sum-running;
            long avg1=running/(long)(i+1);
            long avg2=((n-i-1)!=0)?remaining/(n-i-1):0;
            if(minAvg>Math.abs(avg1-avg2)){
                minAvg=Math.abs(avg1-avg2);
                result=i;
            } 
        }
        return result;
    }
}