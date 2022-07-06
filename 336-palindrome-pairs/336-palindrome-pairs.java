class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        
        int indexOfBlank=-1;
        if(map.containsKey("")){
            indexOfBlank=map.get("");
        }
        
        for(int i=0;i<words.length;i++){
            String word=words[i];
            
            if(indexOfBlank!=-1 && indexOfBlank!=i && isPalinDrome(word)){
                    result.add(Arrays.asList(i,indexOfBlank));
                    result.add(Arrays.asList(indexOfBlank,i));
                }
            
            String reverseWord=new StringBuilder(word).reverse().toString();
            if(map.containsKey(reverseWord) && map.get(reverseWord)!=i){
                result.add(Arrays.asList(i,map.get(reverseWord)));
            }
            
            for(int cut=1;cut<word.length();cut++){
                String left=word.substring(0,cut);
                String right=word.substring(cut);
                
                if(isPalinDrome(left)){
                    String reverseRight=new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reverseRight))
                        result.add(Arrays.asList(map.get(reverseRight),i));
                }
                if(isPalinDrome(right)){
                    String reverseLeft=new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reverseLeft))
                        result.add(Arrays.asList(i,map.get(reverseLeft)));
                }
            }
        }
        
        return result;
    }
    
    public boolean isPalinDrome(String word){
        int start=0,end=word.length()-1;
        while(start<end){
            if(word.charAt(start++)!=word.charAt(end--)) return false;
        }
        return true;
    }
}