class WordDictionary {
    class Trie{
        Trie[] children;
        boolean isEnd;
        
        public Trie(){
            children=new Trie[26];
            isEnd=false;
        }
    }
    Trie root;
    public WordDictionary() {
        root=new Trie();
    }
    
    public void addWord(String word) {
        Trie temp=root;
        for(char letter:word.toCharArray()){
            if(temp.children[letter-'a']==null) temp.children[letter-'a']=new Trie();
            temp=temp.children[letter-'a'];
        }
        temp.isEnd=true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(),0,root);
    }
    
    public boolean match(char[] word,int index,Trie node){
        if(index==word.length) return node.isEnd;
        char c = word[index];
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(node.children[i]!=null && match(word,index+1,node.children[i])) return true;
            }
            return false;
        }
        else{
            return node.children[c-'a']!=null && match(word,index+1,node.children[c-'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */