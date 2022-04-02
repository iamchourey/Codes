class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int count[]=new int[1001];
        int res[]=new int[arr1.length];
        int index=0;
        for(int num:arr1) count[num]++;
        
        for(int num:arr2){
            while(count[num]!=0){
                res[index++]=num;
                count[num]--;
            }
        }
        for(int i=0;i<1001;i++){
            while(count[i]!=0){
                res[index++]=i;
                count[i]--;
            }
        }
        return res;
    }
}