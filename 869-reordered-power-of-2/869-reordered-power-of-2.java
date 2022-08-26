class Solution {
    public boolean reorderedPowerOf2(int n) {
        int freqOfN[]=new int[10];
        int temp=n;
        while(temp!=0){
            freqOfN[temp%10]++;
            temp/=10;
        }
        for(int i=0;i<32;i++){
            int powerOfTwo=(int)Math.pow(2,i);
            int freqOfpowerOfTwo[]=new int[10];
            while(powerOfTwo!=0){
                freqOfpowerOfTwo[powerOfTwo%10]++;
                powerOfTwo/=10;
            }
            if(isEqual(freqOfpowerOfTwo,freqOfN)) return true;
        }
        return false;
    }
    public boolean isEqual(int a1[],int a2[]){
        for(int i=0;i<10;i++){
            if(a1[i]!=a2[i]) return false;
        }
        return true;
    }
}