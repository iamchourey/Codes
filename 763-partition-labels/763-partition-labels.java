class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ls= new ArrayList<>();
        Map<Character,Integer> hm=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
            hm.put(s.charAt(i),i);
        
        int start=-1,end=0;
        
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,hm.get(s.charAt(i)));
            
            if(end==i)
            {
                ls.add(end-start);
                start=end;
            }
        }
        
        return ls;
    }
}