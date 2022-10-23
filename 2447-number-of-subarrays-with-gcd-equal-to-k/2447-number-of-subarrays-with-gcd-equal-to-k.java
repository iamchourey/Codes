class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k!=0) continue;
            int gcd=nums[i];
            for(int j=i;j<nums.length;j++){
                gcd=getGCD(gcd,nums[j]);
                if(gcd==k) result++;
            }
        }
        return result;
    }
    public int getGCD(int a,int b){
        if(a==0) return b;
        return getGCD(b%a,a);
    }
}