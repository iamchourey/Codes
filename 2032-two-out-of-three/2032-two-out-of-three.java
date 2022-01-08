class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        int arr[]=new int[101];
        
        for(int num:nums1)
            arr[num]=1;
        for(int num:nums2)
            arr[num]=arr[num]|(1<<1);
        for(int num:nums3)
            arr[num]=arr[num]|(1<<2);
        
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==3 || arr[i]==5 || arr[i]==6 || arr[i]==7)
                ls.add(i);
        }
        
        return ls;
    }
}