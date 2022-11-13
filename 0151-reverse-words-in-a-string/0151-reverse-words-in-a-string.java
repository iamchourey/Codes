class Solution {
    public String reverseWords(String s) {
        String words[]=s.trim().split(" +");
        int start=0,end=words.length-1;
        while(start<end){
            String temp=words[start];
            words[start]=words[end];
            words[end]=temp;
            start++;
            end--;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++) {
            String word=words[i];
            if(word.equals(" ")) continue;
            sb.append(word);
            if(i!=words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}