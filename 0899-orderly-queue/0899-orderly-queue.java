class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars=s.toCharArray();
        if(k>1){
            Arrays.sort(chars);
            return new String(chars);
        }
        String result=s;
        for(int i=0;i<s.length()-1;i++){
            rotateChars(chars);
            String temp=new String(chars);
            int diff=result.compareTo(temp);
            if(diff>0) result=temp;
        }
        return result;
    }
    public void rotateChars(char[] chars){
        char temp=chars[0];
        for(int i=0;i<chars.length-1;i++){
            chars[i]=chars[i+1];
        }
        chars[chars.length-1]=temp;
    }
}