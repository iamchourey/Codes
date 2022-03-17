class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> hs=new HashSet<>();
        
        for(int num : nums)
            hs.add(num);
        
        return (hs.size()<nums.length);
    }
}