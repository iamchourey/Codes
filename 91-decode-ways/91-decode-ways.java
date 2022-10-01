class Solution {
    public int numDecodings(String s) {
        int memo[]=new int[s.length()];
        return helper(s,0,memo);
    }
    
    public int helper(String s,int index,int[] memo){
        if(index>=s.length()) return 1;
        if(memo[index]!=0) return memo[index];
        if(s.charAt(index)=='0') return 0;
        int ways=0;
        if(s.charAt(index)=='1' && index<s.length()-1)
            ways+=helper(s,index+2,memo);
        if(s.charAt(index)=='2' && index<s.length()-1 && s.charAt(index+1)<'7')
            ways+=helper(s,index+2,memo);
        ways+=helper(s,index+1,memo);
        return memo[index] = ways;
    }
}