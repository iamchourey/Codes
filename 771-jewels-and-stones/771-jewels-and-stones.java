class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int chars[]=new int[128];
        int result=0;
        for(char c:stones.toCharArray())
            chars[c]++;
        for(char c:jewels.toCharArray())
            result+=chars[c];
        
        return result;
    }
}