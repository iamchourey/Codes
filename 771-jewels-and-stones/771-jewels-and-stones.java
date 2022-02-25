class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        Set<Character> hs=new HashSet<>();
        
        for(char c:jewels.toCharArray()){
            hs.add(c);
        }
        
        int result=0;
        
        for(char c:stones.toCharArray()){
            if(hs.contains(c))
                result++;
        }
        
        return result;
    }
}