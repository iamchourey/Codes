class Solution {
    public boolean closeStrings(String word1, String word2) {
        int chars1[]=new int[26];
        int chars2[]=new int[26];
        for(char c:word1.toCharArray()) chars1[c-'a']++;
        for(char c:word2.toCharArray()) chars2[c-'a']++;
        for(int i=0;i<26;i++){
            if((chars1[i]==0 && chars2[i]!=0) || (chars2[i]==0 && chars1[i]!=0)) return false;
        }
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i=0;i<26;i++){
            if(chars1[i]!=chars2[i]) return false;
        }
        return true;
    }
}