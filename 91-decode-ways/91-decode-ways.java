class Solution {
    public int numDecodings(String s) {
        int memo[]=new int[s.length()+1];
        memo[0]=1;
        memo[1]=(s.charAt(0)=='0')?0:1;
        
        for(int i=1;i<s.length();i++){
            int singleDigit=s.charAt(i)-'0';
            int doubleDigit=(s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
            
            if(singleDigit!=0) memo[i+1]+=memo[i];
            if(doubleDigit>=10 && doubleDigit<=26) memo[i+1]+=memo[i-1];
        }
        return memo[s.length()];
    }
}