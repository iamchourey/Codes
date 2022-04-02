class Solution {
    public boolean isPalindrome(String s) {
        String str=s.trim();
        int i=0,j=str.length()-1;
        str=str.toLowerCase();
        System.out.print(str);
        
        while(i<j)
        {
            if((int)str.charAt(i)>=58 && (int)(str.charAt(i))<=64 ||
               (int)str.charAt(i)>=33 && (int)(str.charAt(i))<=47 ||
               (int)str.charAt(i)>=91 && (int)(str.charAt(i))<=96 ||
               (int)str.charAt(i)>=123 && (int)(str.charAt(i))<=126 || str.charAt(i)==' '){
                i++;
                continue;
            }
            
            if((int)str.charAt(j)>=58 && (int)(str.charAt(j))<=64 ||
               (int)str.charAt(j)>=33 && (int)(str.charAt(j))<=47 ||
               (int)str.charAt(j)>=91 && (int)(str.charAt(j))<=96 ||
               (int)str.charAt(j)>=123 && (int)(str.charAt(j))<=126 || str.charAt(j)==' '){
                j--;
                continue;
            }
            if(str.charAt(i)!=str.charAt(j)) return false;
            else{
                ++i;
                --j;
            }
        }
        
        return true;
    }
}