class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        Stack<Integer> stack=new Stack<>();
        long res=0;
        int mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            while(stack.isEmpty()==false && arr[stack.peek()]>=arr[i]){
                int index=stack.pop();
                int right=i-index-1;
                int left=(stack.isEmpty()?index:index-stack.peek()-1);
                long subarrays=(long)((right+1)*(left+1))%mod;
                res+=(long)(arr[index]*subarrays)%mod;
                res%=mod;
            }
            stack.push(i);
        }
        
        while(stack.isEmpty()==false){
            int index=stack.pop();
            int right=arr.length-index-1;
            int left=(stack.isEmpty()?index:index-stack.peek()-1);
            long subarrays=(long)((right+1)*(left+1))%mod;
            res+=(long)(arr[index]*subarrays)%mod;
            res%=mod;
        }
        return (int)res;
    }
}