class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n==0)
            return false;
        if(n==1)
            return true;
        
        return (n>0 && (n&(n-1))==0 && (n&(0x55555555))!=0);
    }
}