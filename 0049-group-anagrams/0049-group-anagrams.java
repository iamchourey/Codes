class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] isProccessed=new boolean[strs.length];
        List<List<String>> result=new ArrayList<>();
        int index=-1;
        for(int i=0;i<strs.length;i++){
            if(isProccessed[i]) continue;
            String curr=strs[i];
            result.add(new ArrayList<>());
            index++;
            isProccessed[i]=true;
            result.get(index).add(curr);
            for(int j=i+1;j<strs.length;j++){
                if(isProccessed[j]) continue;
                if(isAnagram(curr,strs[j])){
                    result.get(index).add(strs[j]);
                    isProccessed[j]=true;
                }
            }
        }
        return result;
    }
    public boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        int[] chars=new int[26];
        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i)-'a']++;
            chars[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(chars[i]!=0) return false;
        }
        return true;
    }
}