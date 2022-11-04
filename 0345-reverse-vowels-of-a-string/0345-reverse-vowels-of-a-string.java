class Solution {
    public String reverseVowels(String s) {
        Set<Character> set=new HashSet<>();
        Stack<Character> stack=new Stack<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        for(char c:s.toCharArray()){
            if(set.contains(c)) stack.push(c);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(set.contains(c)) sb.append(stack.pop());
            else sb.append(c);
        }
        return sb.toString();
    }
}