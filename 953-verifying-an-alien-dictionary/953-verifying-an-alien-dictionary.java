class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> hm=new HashMap<>();
        int i=1;
        for(char c:order.toCharArray()){
            hm.put(c,i++);
        }
        
        for(i=1;i<words.length;i++){
            if(notSorted(words[i],words[i-1],hm)) return false;
        }
        return true;
    }
    public boolean notSorted(String s1,String s2,Map<Character,Integer> hm){
        int n=s1.length(),m=s2.length();
        
        for(int i=0;i<s1.length() && i<s2.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                return hm.get(s1.charAt(i))<hm.get(s2.charAt(i));
        }
        return n<m;
    }
}