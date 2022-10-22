class Solution {
    public String minWindow(String s, String t) {
        
        int start=0,end=0;
        Map<Character,Integer> tmap=new HashMap<>();
        Map<Character,Integer> smap=new HashMap<>();
        int temp=0,charsCount=0;
        String result="";
        
        for(char c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
            charsCount++;
        }
        
        while(end<s.length()){
            char c=s.charAt(end);
            if(tmap.containsKey(c) && tmap.get(c)>smap.getOrDefault(c,0)) temp++;
            smap.put(c,smap.getOrDefault(c,0)+1);
            
            while(temp==charsCount){
                if(result=="" || result.length()>(end-start+1)){
                    result=s.substring(start,end+1);
                }
                char startChar=s.charAt(start);
                smap.put(startChar,smap.get(startChar)-1);
                if(smap.getOrDefault(startChar,0)<tmap.getOrDefault(startChar,0)) temp--;
                start++;
            }
            end++;
        }
        return result;
    }
}