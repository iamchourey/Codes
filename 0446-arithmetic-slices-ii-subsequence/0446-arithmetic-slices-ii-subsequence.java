class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> hm[]=new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            hm[i]=new HashMap<Integer,Integer>();
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                long cd=(long)nums[i]-(long)nums[j];
                if(cd<Integer.MIN_VALUE || cd>Integer.MAX_VALUE) continue;
                if(hm[j].containsKey((int)cd)){
                    ans+=hm[j].get((int)cd);
                    hm[i].put((int)cd,hm[j].getOrDefault((int)cd,0)+1+hm[i].getOrDefault((int)cd,0));
                }
                else{
                    hm[i].put((int)cd,hm[i].getOrDefault((int)cd,0)+1);
                }
            }
        }
        return ans;
    }
}