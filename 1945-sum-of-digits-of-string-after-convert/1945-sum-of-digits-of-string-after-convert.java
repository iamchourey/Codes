class Solution {
    public int getLucky(String s, int k) {
        
        int res=0;
        
        for(char c:s.toCharArray()){
            int temp=(int)c - 96;
            res+=temp<10?temp:temp/10+temp%10;
        }
        
        if(res<10)
            return res;
        k--;
        while(k-- >0 && res>=10){
            res=sumOfDigits(res);
        }
        
        return res;
    }
    
    public int sumOfDigits(int num){
        int res=0;
        
        while(num>0){
            res+=num%10;
            num=num/10;
        }
        
        return res;
    }
}