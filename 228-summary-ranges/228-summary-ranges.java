class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ls=new ArrayList<String>();
        int i=0;
        
        while(i<nums.length){
            
            int start=i;
            int end=i+1;
            
            while(end<nums.length && nums[end] == nums[end-1]+1){
                end++;
            }
            StringBuilder sb=new StringBuilder();
            sb.append(nums[start]);
            if(start!=end-1){
                sb.append("->");
                sb.append(nums[end-1]);
            }
            
            ls.add(sb.toString());
            i=end;
        }
        
        return ls;
    }
}