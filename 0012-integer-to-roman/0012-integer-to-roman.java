class Solution {
    public String intToRoman(int num) {

        String thousands[]={"","M","MM","MMM"};
        String hundreds[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String tens[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String ones[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        String result="";
        
        int thousand=num/1000;
        num=num%1000;
        result=result+thousands[thousand];
        
        int hundred=num/100;
        num=num%100;
        result=result+hundreds[hundred];
        
        int ten=num/10;
        num=num%10;
        result=result+tens[ten];
        
        int one=num;
        result=result+ones[one];
        
        return result;
        

    }
}