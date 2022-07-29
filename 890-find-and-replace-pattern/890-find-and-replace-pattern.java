class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> result=new ArrayList<>();
        
        for(String word:words){
            if(patternMatch(word,pattern)) result.add(word);
        }
        
        return result;
    }
    
    public boolean patternMatch(String word,String pattern){
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        
        for(int i=0;i<pattern.length();i++){
            char pchar=pattern.charAt(i);
            char wchar=word.charAt(i);
        
            if(map.containsKey(pchar)){
                if(map.get(pchar)!=wchar) return false;
            }
            else{
                if(set.contains(wchar)) return false;
                map.put(pchar,wchar);
                set.add(wchar);
            }
        }
        return true;
    }
}