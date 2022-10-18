class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String last=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        char c=last.charAt(0);
        int count=1;
        
        for(int i=1;i<last.length();i++){
            if(last.charAt(i)==c) count++;
            else{
                sb.append((char)('0'+count));
                sb.append(c);
                c=last.charAt(i);
                count=1;
            }
        }
        sb.append((char)('0'+count));
        sb.append(c);
        return sb.toString();
    }
}