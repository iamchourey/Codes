class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    public TrieNode(){
        children=new TrieNode[26];
        isEnd=false;
    }
}
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        buildTrie(words,root);
        int m=board.length,n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,m,n,root,"");
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] board,int x,int y,int m,int n,TrieNode root,String word){
        
        if(x<0 || y<0 || x>=m || y>=n || board[x][y]==' ' || root.children[board[x][y]-'a']==null) return;
        
        char temp=board[x][y];
        board[x][y]=' ';
        word+=temp;
        TrieNode curr=root.children[temp-'a'];
        
        if(curr.isEnd){
            res.add(word);
            curr.isEnd=false;
        }
        
        dfs(board,x+1,y,m,n,curr,word);
        dfs(board,x-1,y,m,n,curr,word);
        dfs(board,x,y+1,m,n,curr,word);
        dfs(board,x,y-1,m,n,curr,word);
        
        board[x][y]=temp;
    }
    
    public void buildTrie(String[] words,TrieNode root){
        
        for(String word:words){
            TrieNode curr=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null) curr.children[c-'a']=new TrieNode();
                curr=curr.children[c-'a'];
            }
            curr.isEnd=true;
        }
    }
}