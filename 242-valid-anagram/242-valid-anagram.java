class Solution {
    public boolean isAnagram(String s, String t) {
        
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(s.indexOf(ch)!=-1)
            {
                s=s.replaceFirst(Character.toString(ch),"");
            }else
                return false;
        }
        
        if(s.isEmpty())
            return true;
        else
            return false;
    }
}