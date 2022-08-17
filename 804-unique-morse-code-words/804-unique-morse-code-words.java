class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] map=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> transformations=new HashSet<>();
        
        for(String word:words){
            String transformation="";
            for(char c:word.toCharArray()){
                transformation+=map[c-'a'];
            }
            transformations.add(transformation);
        }
        
        return transformations.size();
    }
}