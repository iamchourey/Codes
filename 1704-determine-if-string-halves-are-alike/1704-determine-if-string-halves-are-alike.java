class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int count1=0,count2=0;
        
        int mid=s.length()/2,start=0;
        
        while(mid<s.length()){
            char first=s.charAt(start);
            char second=s.charAt(mid);
            if(vowels.contains(first)) count1++;
            if(vowels.contains(second)) count2++;
            start++;
            mid++;
        }
        return count1==count2;
    }
}