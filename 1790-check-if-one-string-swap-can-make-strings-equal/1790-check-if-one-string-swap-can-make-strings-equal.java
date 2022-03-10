class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if(s1.equals(s2)) return true;
        int count1[]=new int[26];
        int count2[]=new int[26];
        int count=0;
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
            
            if(count>2) return false;
        }
        return (count==2 && check(count1,count2));
    }
    
    public boolean check(int a1[],int a2[]){
        for(int i=0;i<26;i++){
            if(a1[i]!=a2[i])
                return false;
        }
        return true;
    }
}