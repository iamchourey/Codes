class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        
        int wordLength=words[0].length();
        int totalWords=words.length;
        int stringLength=wordLength*totalWords;
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        for(int i=0;i<=s.length()-stringLength;i++){
            String concatenated=s.substring(i,i+stringLength);
            Map<String,Integer> tempMap=new HashMap<>();
            
            for(int j=0;j<=concatenated.length()-wordLength;j+=wordLength){
                String tempWord=concatenated.substring(j,j+wordLength);
                tempMap.put(tempWord,tempMap.getOrDefault(tempWord,0)+1);
            }
            
            if(map.equals(tempMap)) result.add(i);
        }
        
        return result;
    }
}