class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> result=new ArrayList<>();
        int[] word2chars=new int[26];
        
        for(String word:words2){
            int[] temp=new int[26];
            for(char c:word.toCharArray()){
                temp[c-'a']++;
                word2chars[c-'a']=Math.max(word2chars[c-'a'],temp[c-'a']);
            }
        }
        
        for(String word:words1){
            int word1chars[]=new int[26];
            for(char c:word.toCharArray()){
                word1chars[c-'a']++;
            }
            if(isUniversal(word1chars,word2chars)) result.add(word);
        }
        
        return result;
    }
    
    public boolean isUniversal(int[] word1chars,int[] word2chars){
        for(int i=0;i<26;i++){
            if(word2chars[i]>word1chars[i]) return false;
        }
        return true;
    }
}