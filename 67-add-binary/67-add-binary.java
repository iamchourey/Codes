class Solution {
    public String addBinary(String a, String b) {
        
        int lenA=a.length()-1,lenB=b.length()-1;
        int sum=0;
        String result="";
        
        while(lenA>=0 || lenB>=0 || sum>0)
        {
            if(lenA>=0)
                sum+=(a.charAt(lenA)-'0');
            if(lenB>=0)
                sum+=(b.charAt(lenB)-'0');
            
            result=(char)(sum%2 + '0')+result;
            sum=sum/2;
            
            --lenA;
            --lenB;
            
        }
        return result;
    }
}