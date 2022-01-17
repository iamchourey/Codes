class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String sa[]=s.split(" ");
        
        Map<Character,String> hm=new HashMap<>();
        
        if(pattern.length()!=sa.length)
            return false;
        
        Set<Character> s1=new HashSet<>();
        Set<String> s2=new HashSet<>();
        
        for(int i=0;i<sa.length;i++)
        {
            s1.add(pattern.charAt(i));
            s2.add(sa[i]);
        }
        
        if(s1.size()!=s2.size())
            return false;
        
        for(int i=0;i<pattern.length();i++)
        {
            if(!hm.containsKey(pattern.charAt(i)))
                hm.put(pattern.charAt(i),sa[i]);
            else if(!hm.get(pattern.charAt(i)).equals(sa[i]))
                return false;
        }
        return true;
    }
}