class Solution {
    public int concatenatedBinary(int n) {
        int mod=1000000007;
        long result=0;
        
        for(int i=1;i<=n;i++){
            result=((result<<countBits(i))+i)%mod;
        }
        return (int)result;
    }
    
    public int countBits(int n){
        int bits=0;
        while(n!=0){
            bits++;
            n=n>>1;
        }
        return bits;
    }
}