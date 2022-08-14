class Solution {
    
    class Pair{
        String word;
        int level;
        
        public Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set=new HashSet<>();
        for(String s:wordList) set.add(s);
        
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        
        while(queue.isEmpty()==false){
            Pair p=queue.poll();
            String word=p.word;
            int level=p.level;
            
            if(word.equals(endWord)) return level;
            
            char[] wordchars=word.toCharArray();
            for(int i=0;i<wordchars.length;i++){
                char prev=wordchars[i];
                for(char c='a';c<='z';c++){
                    wordchars[i]=c;
                    
                    String newWord=new String(wordchars);
                    if(set.contains(newWord)){
                        queue.add(new Pair(newWord,level+1));
                        set.remove(newWord);
                    }
                }
                wordchars[i]=prev;
            }
        }
        return 0;
    }
}