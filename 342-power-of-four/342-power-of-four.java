class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        else if(n<4) return false;
        else return ((n&(n-1))==0 && (n&(0x55555555))!=0);
    }
}