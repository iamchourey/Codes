class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers=new String[nums.length];
        int index=0;
        for(int num:nums) numbers[index++]=Integer.toString(num);
        
        Arrays.sort(numbers,new Comparator<String>(){
            public int compare(String s1,String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if(numbers.length==0 || numbers[0].equals("") || numbers[0].charAt(0)=='0')
            return "0";
        
        StringBuilder sb=new StringBuilder();
        for(String num:numbers) sb.append(num);
        
        return sb.toString();
    }
}