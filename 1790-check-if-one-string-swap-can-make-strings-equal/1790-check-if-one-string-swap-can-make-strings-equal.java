class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if(s1.equals(s2)) return true;
        List<Integer> ls=new ArrayList<>();
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                ls.add(i);
            }
            
            if(count>2) return false;
        }
        
        return (count==0 || (count==2 && s1.charAt(ls.get(0))==s2.charAt(ls.get(1)) && 
                            s1.charAt(ls.get(1))==s2.charAt(ls.get(0))));
    }
}