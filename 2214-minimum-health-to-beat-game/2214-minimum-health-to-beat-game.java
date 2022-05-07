class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        long sum=0;
        int maxDamage=damage[0];
        
        for(int i=0;i<damage.length;i++){
            sum+=damage[i];
            maxDamage=Math.max(maxDamage,damage[i]);
        }
        sum-=Math.min(maxDamage,armor);
        return sum+1;
    }
}