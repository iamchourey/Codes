class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ls=new ArrayList<>();
        
        Integer n1=null,n2=null;
        int c1=0,c2=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(n1!=null && nums[i]==n1)
                c1++;
            else if(n2!=null && nums[i]==n2)
                c2++;
            else if(c1==0)
            {
                n1=nums[i];
                ++c1;
            }else if(c2==0){
                n2=nums[i];
                ++c2;
            }else{
                --c1;
                --c2;
            } 
        }
        
        int freq=nums.length/3;
        c1=0;
        c2=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(n1!=null && nums[i]==n1)
                c1++;
            if(n2!=null && nums[i]==n2)
                c2++;
        }
        
        if(c1>freq)
            ls.add(n1);
        if(c2>freq)
            ls.add(n2);
        
        return ls;
    }
}