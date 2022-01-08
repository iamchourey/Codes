class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        int n1=nums1.length,n2=nums2.length,n3=nums3.length;
        
        Map<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<n1;i++){
            hm.put(nums1[i],1);
        }
        
        Arrays.sort(nums2);
        for(int i=0;i<n2;i++){
            
            if(i>0 && nums2[i]==nums2[i-1])
                continue;
            
            hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+1);
        }
        Arrays.sort(nums3);
        for(int i=0;i<n3;i++){
            
            if(i>0 && nums3[i]==nums3[i-1])
                continue;
            
            hm.put(nums3[i],hm.getOrDefault(nums3[i],0)+1);
        }
        List<Integer> ls=new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>1)
                ls.add(entry.getKey());
        }
        
        return ls;
    }
}