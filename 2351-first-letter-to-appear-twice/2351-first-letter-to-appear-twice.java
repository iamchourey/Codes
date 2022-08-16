class Solution {
    public char repeatedCharacter(String s) {
        
        int countsOfChars[]=new int[26];
        for(char c:s.toCharArray()){
            countsOfChars[c-'a']++;
            if(countsOfChars[c-'a']==2) return c;
        }
        
        return ' ';
    }
}