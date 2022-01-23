class Solution {
    
    public boolean canAdd(int[] freq,int[] tempFreq){
        
        for(int i=0;i<10;i++){
            if(tempFreq[i]>freq[i])
                return false;
        }
        
        return true;
    }
    public int[] findEvenNumbers(int[] digits) {
        
        List<Integer> ls=new ArrayList<>();
        int freq[]=new int[10];
        for(int d:digits){
            freq[d]++;
        }
        
        for(int i=100;i<=999;i=i+2){
            int temp=i;
            int tempFreq[]=new int[10];
            while(temp!=0){
                int d=temp%10;
                tempFreq[d]++;
                temp/=10;
            }
            if(canAdd(freq,tempFreq))
                ls.add(i);
        }
        
        int[] res=new int[ls.size()];
        int index=0;
        for(int n:ls){
            res[index++]=n;
        }
        
        return res;
    }
}