class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> s=new HashSet<>();
        boolean present=false;
        
        for(int i=0;i<wordList.size();i++){
            String str=wordList.get(i);
            
            if(str.compareTo(endWord)==0)
                present=true;
            
            s.add(str);
        }
        
        if(!present)
            return 0;
        
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int depth=0;
        int len=beginWord.length();
        
        while(q.isEmpty()==false)
        {
            depth++;
            int lnode=q.size();
            
            for(int i=0;i<lnode;i++)
            {
                String curr=q.poll();
                
                for(int j=0;j<len;j++)
                {
                    String temp=curr;
                    char[] ch=temp.toCharArray();
                    
                    for(char c='a';c<='z';c++){
                        ch[j]=c;
                        
                        temp=new String(ch);
                        
                        if(temp.compareTo(curr)==0)
                            continue;
                        if(temp.compareTo(endWord)==0)
                            return depth+1;
                        if(s.contains(temp)){
                            q.add(temp);
                            s.remove(temp);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}