class Solution {
    public String getSmallestString(int n, int k) {
        
        char ans[]=new char[n];
        Arrays.fill(ans,'a');
        k-=n;
        
        while(k>0){
            ans[--n]+=Math.min(25,k);
            k-=Math.min(25,k);
        }
        return new String(ans);
    }
}