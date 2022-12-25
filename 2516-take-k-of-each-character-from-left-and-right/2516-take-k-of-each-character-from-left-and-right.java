class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        int[] freq=new int[3];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        if(freq[0]<k || freq[1]<k || freq[2]<k) return -1;
        int result=n;
        int start=0;
        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(freq[0]<k || freq[1]<k || freq[2]<k){
                result=Math.min(result,freq[0]+freq[1]+freq[2]+1);
                while(start<n && c!=s.charAt(start)){
                    freq[s.charAt(start)-'a']++;
                    start++;
                }
                freq[s.charAt(start)-'a']++;
                start++;
            }
        }
        return Math.min(result,freq[0]+freq[1]+freq[2]);
    }
}